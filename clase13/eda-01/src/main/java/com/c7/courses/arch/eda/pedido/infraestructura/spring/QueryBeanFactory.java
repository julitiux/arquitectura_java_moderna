package com.c7.courses.arch.eda.pedido.infraestructura.spring;

import com.c7.courses.arch.eda.pedido.aplicacion.servicio.PedidoQueryService;
import com.c7.courses.arch.eda.pedido.projections.PedidoProjection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryBeanFactory {

    @Bean
    PedidoQueryService pedidoQueryService(PedidoProjection pedidoProjection) {
        return new PedidoQueryService(pedidoProjection);
    }
}
