package com.c7.course.arch.clean.pedidos.application.exceptions;

/**
 * Exception thrown when an attempt is made to cancel an order that cannot be canceled.
 * This exception indicates that the specific business rule or condition for the cancellation
 * process prevents the order from being canceled.
 */
public class PedidoNoCancelableException extends Exception {
    public PedidoNoCancelableException(String message) {
        super(message);
    }
}
