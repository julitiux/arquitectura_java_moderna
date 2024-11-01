package com.c7.courses.arch.eda.pedido.infraestructura.spring;

import com.c7.courses.arch.eda.pedido.aplicacion.servicio.PedidoQueryService;
import com.c7.courses.arch.eda.pedido.infraestructura.salida.projections.InMemoryPedidoProjection;
import com.c7.courses.arch.eda.pedido.infraestructura.salida.projections.RedisPedidoProjection;
import com.c7.courses.arch.eda.pedido.projections.PedidoProjection;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class QueryBeanFactory {

    @Bean
    public PedidoQueryService pedidoQueryService(PedidoProjection pedidoProjection) {
        return new PedidoQueryService(pedidoProjection);
    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory(@Value("${SPRING_DATA_REDIS_HOST:localhost}") String host) {

        return new LettuceConnectionFactory(new RedisStandaloneConfiguration(host, 6379));
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<?, ?> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        return template;
    }

    @Bean
    PedidoProjection pedidoProjection(RedisTemplate<?, ?> redisTemplate, ObjectMapper objectMapper) {
        //return new RedisPedidoProjection(redisTemplate, objectMapper);
        return new InMemoryPedidoProjection();
    }
}
