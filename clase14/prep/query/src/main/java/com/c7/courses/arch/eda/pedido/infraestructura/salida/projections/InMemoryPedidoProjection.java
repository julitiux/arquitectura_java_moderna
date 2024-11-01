package com.c7.courses.arch.eda.pedido.infraestructura.salida.projections;

import com.c7.courses.arch.eda.event.Evento;
import com.c7.courses.arch.eda.event.PedidoConfirmadoEvent;
import com.c7.courses.arch.eda.event.PedidoCreadoEvent;
import com.c7.courses.arch.eda.pedido.projections.PedidoProjection;
import com.c7.courses.arch.eda.pedido.projections.PedidoView;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryPedidoProjection implements PedidoProjection {
    private final Map<String, PedidoView> pedidos = new HashMap<>();

    public void aplicar(PedidoCreadoEvent evento) {
        PedidoView pedidoView = new PedidoView(evento.getEntityId(), evento.getClienteId(), false);
        pedidos.put(evento.getEntityId(), pedidoView);
    }

    public void aplicar(PedidoConfirmadoEvent evento) {
        this.obtenerPedido(evento.getEntityId())
            .ifPresent(pedidoView -> pedidoView.setEsConfirmado(true));
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
        return Optional.ofNullable(pedidos.get(pedidoId));
    }
}
