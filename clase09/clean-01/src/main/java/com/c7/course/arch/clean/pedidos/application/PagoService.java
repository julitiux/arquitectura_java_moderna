package com.c7.course.arch.clean.pedidos.application;

import java.math.BigDecimal;

/**
 * PagoService es una interfaz que define el contrato para servicios de
 * procesamiento de pagos en el sistema.
 */
public interface PagoService {
    /**
     * Procesa un pago basado en el método de pago y la cantidad especificada.
     *
     * @param metodoPago el método de pago que se utilizará para procesar el pago.
     *                   Puede ser tarjeta de crédito, PayPal u otro método aceptado.
     * @param cantidad   la cantidad a pagar, representada como un BigDecimal.
     * @return true si el pago fue procesado exitosamente, false en caso contrario.
     */
    boolean procesarPago(String metodoPago, BigDecimal cantidad);
}
