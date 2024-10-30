package com.c7.courses.arch.eda.pedido.infraestructura.salida.repository;

import com.c7.courses.arch.eda.event.Evento;
import com.c7.courses.arch.eda.event.EventoFactory;
import com.c7.courses.arch.eda.pedido.domain.repository.EventStore;
import com.c7.courses.arch.eda.pedido.infraestructura.salida.repository.entity.JpaEntityEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class SpringDataJpaEventStore implements EventStore {
    private final JpaEntityEventRepository jpaEntityEventRepository;
    private final ObjectMapper jsonMapper;
    private final RabbitTemplate rabbitTemplate;
    private final static Logger logger = LoggerFactory.getLogger(SpringDataJpaEventStore.class);

    public SpringDataJpaEventStore(JpaEntityEventRepository jpaEntityEventRepository, RabbitTemplate rabbitTemplate) {
        this.jpaEntityEventRepository = jpaEntityEventRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.jsonMapper = new ObjectMapper();
        this.jsonMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void guardarEventos(String entity, String entityId, List<Evento> eventos) {
        eventos.forEach(
            evento -> this.jpaEntityEventRepository.findById(evento.getEventId())
                .ifPresentOrElse(
                    jpaEntityEvent -> logger.info("Evento Existente {}.", jpaEntityEvent),
                    () -> {
                        logger.info("Evento Nuevo {}", evento);
                        manejaNuevoEvento(entity, entityId, evento);
                    }));
    }

    private void manejaNuevoEvento(String entity, String entityId, Evento evento) {
        var jpaEntityEvent = saveEntityEvent(entity, entityId, evento);
        publicaEvento(jpaEntityEvent);
    }

    private void publicaEvento(JpaEntityEvent jpaEntityEvent) {
        try {
            String jsonEvento = this.jsonMapper.writeValueAsString(jpaEntityEvent);
            this.rabbitTemplate.convertAndSend("pedido", jsonEvento);
        } catch (JsonProcessingException e) {
            // en la vida real aqui debe haber manejo de errores, reintentos, etc...
            logger.error(e.getMessage(), e);
        }
    }

    private JpaEntityEvent saveEntityEvent(String entity, String entityId, Evento evento) {
        try {
            String jsonEvento = this.jsonMapper.writeValueAsString(evento);
            JpaEntityEvent jpaEntityEvent = new JpaEntityEvent();
            jpaEntityEvent.setId(evento.getEventId());
            jpaEntityEvent.setEntityName(entity);
            jpaEntityEvent.setEntityId(entityId);
            jpaEntityEvent.setEventPayload(jsonEvento);
            jpaEntityEvent.setCreatedAt(LocalDateTime.now());
            return this.jpaEntityEventRepository.save(jpaEntityEvent);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Evento> obtenerEventos(String entity, String entityId) {
        return this.jpaEntityEventRepository.findAllByEntityNameAndEntityIdOrderByCreatedAt(entity, entityId)
            .stream()
            .map(event -> EventoFactory.fromJson(this.jsonMapper, event.getEventPayload()))
            .toList();
    }
}
