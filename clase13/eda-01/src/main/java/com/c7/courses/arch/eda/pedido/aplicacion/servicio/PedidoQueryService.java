package com.c7.courses.arch.eda.pedido.aplicacion.servicio;

import com.c7.courses.arch.eda.pedido.projections.PedidoProjection;
import com.c7.courses.arch.eda.pedido.projections.PedidoView;
import java.util.Optional;

/**
 * PedidoQueryService se encarga de realizar consultas relacionadas con los pedidos.
 * Utiliza una instancia de PedidoProjection para realizar las consultas.
 */
public class PedidoQueryService {
    private final PedidoProjection pedidoProjection;

    public PedidoQueryService(PedidoProjection pedidoProjection) {
        this.pedidoProjection = pedidoProjection;
    }

    public Optional<PedidoView> obtenerPedido(String pedidoId) {
        return pedidoProjection.obtenerPedido(pedidoId);
    }
}

