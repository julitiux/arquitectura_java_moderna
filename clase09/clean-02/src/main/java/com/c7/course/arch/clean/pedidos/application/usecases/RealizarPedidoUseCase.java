package com.c7.course.arch.clean.pedidos.application.usecases;

import com.c7.course.arch.clean.pedidos.application.exceptions.PedidoInvalidoException;

/**
 * RealizarPedidoUseCase es una interfaz que define la operación para procesar
 * la realización de un pedido basándose en la información proporcionada.
 */
public interface RealizarPedidoUseCase {
    /**
     * Procesa la realización de un pedido basado en la información proporcionada.
     *
     * @param input objeto PedidoInput que contiene los detalles del pedido,
     *              tales como el ID del cliente, la lista de IDs de productos,
     *              y el método de pago.
     * @return un objeto PedidoOutput que contiene los detalles del pedido
     * realizado, incluyendo el ID del pedido, su estado y el total.
     * @throws PedidoInvalidoException si la información del pedido es inválida
     *                                 o no cumple con los requisitos.
     */
    PedidoOutput realizarPedido(PedidoInput input) throws PedidoInvalidoException;
}
