package com.c7.curso.arch.hexagonal.infraestructura.salida.servicioexterno;

import com.c7.curso.arch.hexagonal.dominio.gateway.PaymentGateway;
import com.c7.curso.arch.hexagonal.dominio.modelo.DetallesPago;

public class PaymentGatewayStripe implements PaymentGateway {
    @Override
    public boolean procesarPago(DetallesPago detallesPago) {
        // Lógica para interactuar con la API de Stripe
        // Ejemplo simplificado: realizar una solicitud a la API de Stripe y devolver si fue exitosa
        return true; // o false en caso de error en el pago
    }
}
