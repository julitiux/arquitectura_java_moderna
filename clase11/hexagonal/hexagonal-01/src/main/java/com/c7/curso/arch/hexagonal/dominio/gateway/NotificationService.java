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
     * Notifica que el estado de un pedido ha cambiado.
     *
     * @param pedido el pedido cuyo estado ha cambiado y se debe notificar.
     */
    void notificarCambioEstado(Pedido pedido);
}
