package com.c7.curso.arch.hexagonal.dominio.gateway;

import com.c7.curso.arch.hexagonal.dominio.modelo.Pedido;

/**
 * La interfaz PaymentGateway define el contrato para el procesamiento de pagos
 * en el sistema. Un PaymentGateway implementa la lógica necesaria para procesar
 * el pago de un pedido específico.
 */
public interface PaymentGateway {
    /**
     * Procesa el pago de un pedido específico utilizando la lógica de la pasarela de pagos.
     *
     * @param pedido El pedido que se desea procesar para el pago.
     * @return true si el pago se procesó exitosamente, false en caso contrario.
     */
    boolean procesarPago(Pedido pedido);
}
