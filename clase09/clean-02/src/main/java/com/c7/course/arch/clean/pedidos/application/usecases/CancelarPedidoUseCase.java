package com.c7.course.arch.clean.pedidos.application.usecases;

import com.c7.course.arch.clean.pedidos.application.exceptions.PedidoNoCancelableException;

/**
 * CancelarPedidoUseCase es una interfaz que define la operación para cancelar
 * un pedido existente en el sistema.
 */
public interface CancelarPedidoUseCase {
    /**
     * Cancela un pedido existente en el sistema si cumple con las condiciones
     * necesarias para la cancelación.
     *
     * @param pedidoId el ID del pedido que se desea cancelar
     * @throws PedidoNoCancelableException si el pedido no se puede cancelar debido
     *                                     a condiciones de negocio específicas
     */
    void cancelarPedido(Long pedidoId) throws PedidoNoCancelableException;
}
