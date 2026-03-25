package com.c7.course.arch.clean.pedidos.application.exceptions;

/**
 * Señala que un pedido es inválido o no cumple con los requisitos necesarios
 * para ser procesado.
 */
public class PedidoInvalidoException extends Exception {
    public PedidoInvalidoException(String message) {
        super(message);
    }
}
