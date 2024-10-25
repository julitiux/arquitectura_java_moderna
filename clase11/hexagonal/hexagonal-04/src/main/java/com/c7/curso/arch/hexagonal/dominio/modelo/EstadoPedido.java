package com.c7.curso.arch.hexagonal.dominio.modelo;

/**
 * El enum EstadoPedido representa los diversos estados que un pedido puede tener en su ciclo de vida.
 * <p>
 * PENDIENTE: El pedido ha sido creado pero aún no ha sido pagado.
 * PAGADO: El pedido ha sido pagado e iniciará el proceso de preparación.
 * PREPARANDO: El pedido está en proceso de preparación.
 * LISTO_PARA_RECOGER: El pedido está listo para ser recogido por el cliente.
 * EN_CAMINO: El pedido ha sido enviado y está en camino hacia el destino de entrega.
 * ENTREGADO: El pedido ha sido entregado al destinatario.
 * CANCELADO: El pedido ha sido cancelado y no se llevará a cabo.
 */
public enum EstadoPedido {
    PENDIENTE, PAGADO, PREPARANDO, LISTO_PARA_RECOGER, EN_CAMINO, ENTREGADO, CANCELADO
}
