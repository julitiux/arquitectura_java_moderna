package com.c7.courses.arch.eda.pedido.infraestructura.spring;

import com.c7.courses.arch.eda.pedido.aplicacion.servicio.DefaultPedidoCommandService;
import com.c7.courses.arch.eda.pedido.domain.repository.EventStore;
import com.c7.courses.arch.eda.pedido.domain.service.PedidoCommandService;
import com.c7.courses.arch.eda.pedido.infraestructura.salida.repository.JpaEntityEventRepository;
import com.c7.courses.arch.eda.pedido.infraestructura.salida.repository.SpringDataJpaEventStore;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanFactory {
    @Bean
    public EventStore eventStore(JpaEntityEventRepository eventRepository, RabbitTemplate rabbitTemplate) {
        return new SpringDataJpaEventStore(eventRepository, rabbitTemplate);
    }

    @Bean
    public PedidoCommandService pedidoCommandService(EventStore eventStore) {
        return new DefaultPedidoCommandService(eventStore);
    }
}
