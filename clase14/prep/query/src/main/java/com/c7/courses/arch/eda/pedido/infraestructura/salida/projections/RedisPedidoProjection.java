package com.c7.courses.arch.eda.pedido.infraestructura.salida.projections;

import com.c7.courses.arch.eda.event.Evento;
import com.c7.courses.arch.eda.event.PedidoConfirmadoEvent;
import com.c7.courses.arch.eda.event.PedidoCreadoEvent;
import com.c7.courses.arch.eda.pedido.projections.PedidoProjection;
import com.c7.courses.arch.eda.pedido.projections.PedidoView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisPedidoProjection implements PedidoProjection {
    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    public RedisPedidoProjection(RedisTemplate redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void aplicar(Evento evento) {
        switch (evento) {
            case PedidoCreadoEvent pedidoCreadoEvent:
                aplicar(pedidoCreadoEvent);
                break;
            case PedidoConfirmadoEvent pedidoConfirmadoEvent:
                aplicar(pedidoConfirmadoEvent);
                break;
            default:
                System.out.println("Evento no soportado: " + evento);
        }
    }

    @Override
    public Optional<PedidoView> obtenerPedido(String pedidoId) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(pedidoId))
            .map(this::fromJSON);
    }

    public void aplicar(PedidoCreadoEvent evento) {
        PedidoView pedidoView = new PedidoView(evento.getEntityId(), evento.getClienteId(), false);
        String jsonEvent = toJSON(pedidoView);
        redisTemplate.opsForValue().set(evento.getEntityId(), jsonEvent);
    }

    public void aplicar(PedidoConfirmadoEvent evento) {
        this.obtenerPedido(evento.getEntityId())
            .map(pedidoView -> {
                pedidoView.setEsConfirmado(true);
                String jsonEvent = toJSON(pedidoView);
                redisTemplate.opsForValue().set(evento.getEntityId(), jsonEvent);
                return pedidoView;
            });
    }

    private String toJSON(PedidoView pedidoView) {
        try {
            return objectMapper.writeValueAsString(pedidoView);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private PedidoView fromJSON(String json) {
        try {
            return objectMapper.readValue(json, PedidoView.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
