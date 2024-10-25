package com.c7.curso.arch.hexagonal.dominio.gateway;

import com.c7.curso.arch.hexagonal.dominio.modelo.Pedido;

/**
 * La interfaz NotificationService define el contrato para el envío de notificaciones en el sistema.
 * Esta interfaz se utiliza para notificar diferentes eventos relacionados con el ciclo de vida de los pedidos.
 */
public interface NotificationService {

    /**
     * Notifica que un pedido ha sido creado.
     *
     * @param pedido el pedido que ha sido creado y debe ser notificado.
     */
    void notificarPedidoCreado(Pedido pedido);

    /**
     * Notifica la asignación de un pedido a un repartidor específico.
     *
     * @param pedido el pedido que ha sido asignado a un repartidor.
     * @param repartidorId el identificador del repartidor al que se ha asignado el pedido.
     */
    void notificarAsignacionPedido(Pedido pedido, Long repartidorId);

    /**
     * Notifica que la entrega de un pedido ha sido completada.
     *
     * @param pedido el pedido cuya entrega ha sido completada y debe ser notificado.
     */
    void notificarEntregaCompletada(Pedido pedido);

    /**
     * Notifica que el pago de un pedido ha sido exitoso.
     *
     * @param pedido el pedido cuyo pago ha sido procesado exitosamente.
     */
    void notificarPagoExitoso(Pedido pedido);
}
