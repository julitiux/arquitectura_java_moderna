package com.c7.curso.arch.hexagonal.dominio.gateway;

import com.c7.curso.arch.hexagonal.dominio.modelo.DetallesPago;

/**
 * La interfaz PaymentGateway define el contrato para el procesamiento de pagos
 * en el sistema. Un PaymentGateway implementa la lógica necesaria para procesar
 * el pago de un pedido específico.
 */
public interface PaymentGateway {

    /**
     * Procesa el pago de un pedido específico utilizando la lógica de la pasarela de pagos.
     *
     * @param detallesPago los detalles del pago que se debe procesar, incluyendo información
     *                     como número de tarjeta, nombre del titular, fecha de expiración,
     *                     código de seguridad y monto.
     * @return true si el pago fue procesado exitosamente, false en caso contrario.
     */
    boolean procesarPago(DetallesPago detallesPago);
}
