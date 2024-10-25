package com.c7.curso.arch.hexagonal.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * La clase Pedido representa un pedido realizado por un usuario en un sistema de compra.
 * Contiene información sobre el usuario que realizó el pedido, los items que forman parte
 * del pedido, la dirección de entrega y el estado actual del pedido.
 *
 */
@Setter
@Getter
public class Pedido {
    private Long id;
    private Long usuarioId;
    private List<Item> items;
    private String direccionEntrega;
    private EstadoPedido estado;
    private Long repartidorId;

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

    /**
     * Asigna un repartidor al pedido dado.
     *
     * @param repartidorId el identificador del repartidor que se va a asignar
     * @throws IllegalStateException si el estado del pedido no es LISTO_PARA_RECOGER
     */
    public void asignarRepartidor(Long repartidorId) {
        if (this.estado != EstadoPedido.LISTO_PARA_RECOGER) {
            throw new IllegalStateException("No se puede asignar un repartidor si el pedido no está listo para ser recogido.");
        }
        this.repartidorId = repartidorId;
    }

    /**
     * Cambia el estado actual del pedido al estado proporcionado.
     *
     * @param estadoPedido el nuevo estado que se desea asignar al pedido
     */
    public void cambiarEstado(EstadoPedido estadoPedido) {
        this.estado = estadoPedido;
    }
}

