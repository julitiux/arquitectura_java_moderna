package com.c7.curso.arch.hexagonal.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * La clase Pedido representa un pedido realizado por un usuario en un sistema de compra.
 * Contiene información sobre el usuario que realizó el pedido, los items que forman parte
 * del pedido, la dirección de entrega y el estado actual del pedido.
 *
 * Métodos principales:
 *
 * - pagar(): Marca el pedido como PAGADO si está en estado PENDIENTE. Si el estado es diferente,
 *   lanza una excepción.
 *
 * - marcarComoPreparado(): Marca el pedido como PREPARANDO si está en estado PAGADO. Si el estado
 *   es diferente, lanza una excepción.
 */
@Setter
@Getter
public class Pedido {
    private Long id;
    private Long usuarioId;
    private List<Item> items;
    private String direccionEntrega;
    private EstadoPedido estado;

    public Pedido(Long usuarioId, List<Item> items, String direccionEntrega) {
        this.usuarioId = usuarioId;
        this.items = items;
        this.direccionEntrega = direccionEntrega;
        this.estado = EstadoPedido.PENDIENTE;
    }

    /**
     * Marca el pedido como PAGADO si el estado actual es PENDIENTE.
     * Si el estado del pedido no es PENDIENTE, lanza una excepción.
     *
     * @throws IllegalStateException si el pedido no está en estado PENDIENTE.
     */
    public void pagar() {
        if (this.estado == EstadoPedido.PENDIENTE) {
            this.estado = EstadoPedido.PAGADO;
        } else {
            throw new IllegalStateException("El pedido no se puede pagar en su estado actual.");
        }
    }

    /**
     * Marca el pedido como PREPARANDO si el estado actual es PAGADO.
     * Si el estado del pedido no es PAGADO, lanza una excepción.
     *
     * @throws IllegalStateException si el pedido no está en estado PAGADO.
     */
    public void marcarComoPreparado() {
        if (this.estado == EstadoPedido.PAGADO) {
            this.estado = EstadoPedido.PREPARANDO;
        } else {
            throw new IllegalStateException("El pedido no se puede preparar en su estado actual.");
        }
    }
}

