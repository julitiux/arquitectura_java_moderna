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

    @Override
    public void notificarAsignacionPedido(Pedido pedido, Long repartidorId) {
        String mensajeRepartidor = String.format("Se te ha asignado el pedido #%d.", pedido.getId());
        String mensajeUsuario = String.format("Tu pedido #%d ha sido recogido por el repartidor y está en camino.", pedido.getId());

        // Notificar al repartidor
        // pushNotificationService.enviarNotificacion(repartidorId, mensajeRepartidor);

        // Notificar al usuario
        // pushNotificationService.enviarNotificacion(pedido.getUsuarioId(), mensajeUsuario);
    }

    @Override
    public void notificarEntregaCompletada(Pedido pedido) {
        String mensaje = String.format("Tu pedido #%d ha sido entregado.", pedido.getId());
        // pushNotificationService.enviarNotificacion(pedido.getUsuarioId(), mensaje);
    }
}
