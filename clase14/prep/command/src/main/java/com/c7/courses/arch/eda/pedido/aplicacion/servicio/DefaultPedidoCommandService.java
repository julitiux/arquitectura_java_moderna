package com.c7.courses.arch.eda.pedido.aplicacion.servicio;

import com.c7.courses.arch.eda.pedido.command.CrearPedidoCommand;
import com.c7.courses.arch.eda.pedido.domain.model.Pedido;
import com.c7.courses.arch.eda.pedido.domain.repository.EventStore;
import com.c7.courses.arch.eda.pedido.domain.service.PedidoCommandService;

public class DefaultPedidoCommandService implements PedidoCommandService {
    private final EventStore eventStore;

    public DefaultPedidoCommandService(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void crearPedido(CrearPedidoCommand command) {
        Pedido pedido = new Pedido(command.getPedidoId(), command.getClienteId());
        eventStore.guardarEventos("pedido", command.getPedidoId(), pedido.getEventos());
    }

    @Override
    public void confirmarPedido(String pedidoId) {
        Pedido pedido = reconstruirPedidoDesdeEventos(eventStore, pedidoId);
        pedido.confirmarPedido();
        eventStore.guardarEventos("pedido", pedidoId, pedido.getEventos());
    }

}

