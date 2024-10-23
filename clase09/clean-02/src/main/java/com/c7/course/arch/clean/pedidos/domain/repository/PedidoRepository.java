package com.c7.course.arch.clean.pedidos.domain.repository;

import com.c7.course.arch.clean.pedidos.domain.Pedido;

import java.util.Optional;

/**
 * PedidoRepository es una interfaz que define las operaciones básicas para
 * la gestión de pedidos en el sistema. Provee métodos para guardar y obtener
 * pedidos basados en su identificador único.
 */
public interface PedidoRepository {
    /**
     * Guarda un nuevo pedido en el sistema.
     *
     * @param pedido El objeto Pedido que contiene la información del pedido a guardar.
     * @return El objeto Pedido guardado con su identificador único generado.
     */
    Pedido guardarPedido(Pedido pedido);

    /**
     * Obtiene un pedido por su identificador único.
     *
     * @param id El identificador único del pedido que se desea obtener.
     * @return Un Optional que contiene el pedido si se encuentra, o vacío si no existe un pedido con el identificador proporcionado.
     */
    Optional<Pedido> obtenerPedidoPorId(Long id);

    /**
     * Actualiza la información de un pedido existente en el sistema.
     *
     * @param pedido El objeto Pedido con la información actualizada.
     * @return El objeto Pedido actualizado.
     */
    Pedido actualizarPedido(Pedido pedido);
}
