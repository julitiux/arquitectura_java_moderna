package com.c7.curso.arch.hexagonal.dominio.repositorio;

import com.c7.curso.arch.hexagonal.dominio.modelo.Pedido;

/**
 * La interfaz PedidoRepository define las operaciones de persistencia para la entidad Pedido.
 * Incluye métodos para guardar, buscar por ID y actualizar pedidos en el sistema.
 */
public interface PedidoRepository {
    /**
     * Guarda un pedido en el sistema de persistencia.
     *
     * @param pedido el pedido que se desea guardar.
     */
    void guardar(Pedido pedido);

    /**
     * Busca y devuelve un pedido a partir de su identificador único.
     *
     * @param pedidoId el identificador único del pedido que se desea buscar.
     * @return el pedido correspondiente al identificador dado, o null si no se encuentra.
     */
    Pedido buscarPorId(Long pedidoId);

    /**
     * Actualiza la entidad Pedido existente en el sistema de persistencia.
     * Se espera que el pedido proporcionado tenga un identificador válido que
     * corresponda a un pedido ya almacenado.
     *
     * @param pedido el pedido que se desea actualizar.
     */
    void actualizar(Pedido pedido);
}
