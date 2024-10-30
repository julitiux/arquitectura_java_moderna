package com.c7.courses.arch.eda.pedido.infraestructura.entrada.rabbit;

import com.c7.courses.arch.eda.event.Evento;
import com.c7.courses.arch.eda.event.EventoFactory;
import com.c7.courses.arch.eda.pedido.projections.PedidoProjection;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventListenerRabbitAdapter {
    private final PedidoProjection pedidoProjection;
    private final ObjectMapper jsonMapper;

    private final static Logger logger = LoggerFactory.getLogger(EventListenerRabbitAdapter.class);

    public EventListenerRabbitAdapter(PedidoProjection pedidoProjection) {
        this.pedidoProjection = pedidoProjection;
        this.jsonMapper = new ObjectMapper();
        this.jsonMapper.registerModule(new JavaTimeModule());
    }

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        try {
            var stringObjectMap = EventoFactory.fromJsonAsMap(jsonMapper, message);
            logger.debug("El mapa {}", stringObjectMap);

            Object objectEventPayload = stringObjectMap.get("eventPayload");
            if (objectEventPayload instanceof String eventPayload) {
                Evento evento = EventoFactory.fromJson(jsonMapper, eventPayload);
                logger.debug("Evento: {}", evento);
                this.pedidoProjection.aplicar(evento);
            }

        } catch (RuntimeException e) {
            // Si no atrapamos errores aqui, el mensaje se regresa a Rabbit y podria quedarse ahi por siempre
            // aunque.... existe un patron para esto... DeadLetterQueue...
            System.out.println("UPS!");
        }
    }
}
