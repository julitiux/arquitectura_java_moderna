package com.c7.courses.arch.eda.pedido.projections;

import com.c7.courses.arch.eda.event.Evento;
import java.util.Optional;

/**
 * La interfaz PedidoProjection define los métodos necesarios para aplicar eventos
 * y obtener información de pedidos proyectados.
 */
public interface PedidoProjection {

    /**
     * Aplica un evento recibido a la proyección de pedidos.
     *
     * @param evento el evento que se va a aplicar.
     */
    void aplicar(Evento evento);

    /**
     * Obtiene una vista opcional del pedido basado en su ID.
     *
     * @param pedidoId El identificador del pedido que se desea obtener.
     * @return Un Optional que contiene la vista del pedido si existe, o un Optional vacío si no se encuentra.
     */
    Optional<PedidoView> obtenerPedido(String pedidoId);
}
