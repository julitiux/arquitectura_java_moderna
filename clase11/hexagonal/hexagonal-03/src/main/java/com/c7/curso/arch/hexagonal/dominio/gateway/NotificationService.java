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
}
