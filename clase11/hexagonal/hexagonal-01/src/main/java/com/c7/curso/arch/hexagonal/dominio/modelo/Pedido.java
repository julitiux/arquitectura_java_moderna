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

    /**
     * Cambia el estado actual del pedido al nuevo estado especificado.
     *
     * @param nuevoEstado el nuevo estado al que se desea cambiar el estado actual del pedido.
     * @throws IllegalStateException si el nuevo estado no es válido para el cambio desde el estado actual.
     */
    public void cambiarEstado(EstadoPedido nuevoEstado) {
        if (esCambioDeEstadoValido(nuevoEstado)) {
            this.estado = nuevoEstado;
        } else {
            throw new IllegalStateException("El cambio de estado no es válido.");
        }
    }

    /**
     * Verifica si un cambio de estado es válido para el pedido actual.
     *
     * @param nuevoEstado el nuevo estado al que se desea cambiar el estado actual del pedido.
     * @return true si el cambio de estado es válido, de lo contrario, false.
     */
    private boolean esCambioDeEstadoValido(EstadoPedido nuevoEstado) {
        switch (this.estado) {
            case PENDIENTE:
                return nuevoEstado == EstadoPedido.PAGADO || nuevoEstado == EstadoPedido.CANCELADO;
            case PAGADO:
                return nuevoEstado == EstadoPedido.PREPARANDO;
            case PREPARANDO:
                return nuevoEstado == EstadoPedido.LISTO_PARA_RECOGER;
            case LISTO_PARA_RECOGER:
                return nuevoEstado == EstadoPedido.EN_CAMINO;
            case EN_CAMINO:
                return nuevoEstado == EstadoPedido.ENTREGADO;
            default:
                return false;
        }
    }
}

