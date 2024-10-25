package com.c7.curso.arch.hexagonal.infraestructura.salida.servicioexterno;

import com.c7.curso.arch.hexagonal.dominio.gateway.NotificationService;
import com.c7.curso.arch.hexagonal.dominio.modelo.Pedido;

public class NotificationServiceImpl implements NotificationService {

    @Override
    public void notificarPedidoCreado(Pedido pedido) {
        String mensaje = String.format("El estado de su pedido #%d ha cambiado a %s.", pedido.getId(), pedido.getEstado().name());
        // Aquí podríamos llamar a servicios externos para enviar la notificación:
        // emailService.enviarEmail(pedido.getUsuarioEmail(), mensaje);
        // smsService.enviarSMS(pedido.getUsuarioTelefono(), mensaje);
        // o pushNotificationService.enviarNotificacion(pedido.getUsuarioId(), mensaje);
    }
}
