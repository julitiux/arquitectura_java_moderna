package com.c7.course.arch.clean.pedidos.infrastructure.services;

import com.c7.course.arch.clean.pedidos.application.PagoService;

import java.math.BigDecimal;

/**
 * PagoService. Este es un servicio externo simulado que procesa el pago.
 */
public class StripePagoService implements PagoService {
    public boolean procesarPago(String metodoPago, BigDecimal cantidad) {
        // Simulación del proceso de pago (siempre exitoso para este ejemplo)
        return true;
    }
}
