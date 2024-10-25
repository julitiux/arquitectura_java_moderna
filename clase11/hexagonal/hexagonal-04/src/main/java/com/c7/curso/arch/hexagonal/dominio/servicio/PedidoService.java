package com.c7.curso.arch.hexagonal.dominio.servicio;

import com.c7.curso.arch.hexagonal.dominio.modelo.Item;
import com.c7.curso.arch.hexagonal.dominio.modelo.Pedido;

import java.util.List;

/**
 * La interfaz PedidoService define las operaciones principales relacionadas con la gestión
 * de pedidos en un sistema de compras.
 * Esto incluye la creación y pago de pedidos.
 */
public interface PedidoService {
    /**
     * Crea un nuevo pedido para un usuario específico con los ítems proporcionados y una dirección de entrega.
     * El pedido se crea en estado PENDIENTE.
     *
     * @param usuarioId Identificador del usuario que realiza el pedido.
     * @param items Lista de ítems que forman parte del pedido.
     * @param direccionEntrega Dirección a la que se enviará el pedido.
     * @return El pedido creado con el estado inicial PENDIENTE.
     */
    Pedido crearPedido(Long usuarioId, List<Item> items, String direccionEntrega);

    Pedido crearPedido(Long usuarioId, String direccionEntrega, List<Long> items);

    /**
     * Marca un pedido como pagado si actualmente se encuentra en estado PENDIENTE.
     * Si el estado del pedido no es PENDIENTE, lanzará una excepción.
     *
     * @param pedidoId Identificador del pedido que se desea pagar.
     * @throws IllegalStateException si el pedido no se encuentra en estado PENDIENTE.
     */
    void pagarPedido(Long pedidoId);

    /**
     * Asigna un pedido a un repartidor específico.
     *
     * @param pedidoId Identificador del pedido que se asignará.
     * @param repartidorId Identificador del repartidor al que se le asignará el pedido.
     */
    void asignarPedidoARepartidor(Long pedidoId, Long repartidorId);

    /**
     * Marca un pedido como entregado por un repartidor específico.
     *
     * @param pedidoId Identificador del pedido que se completará.
     * @param repartidorId Identificador del repartidor que ha completado la entrega.
     */
    void completarEntrega(Long pedidoId, Long repartidorId);
}
