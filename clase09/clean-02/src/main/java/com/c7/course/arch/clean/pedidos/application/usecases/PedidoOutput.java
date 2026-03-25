package com.c7.course.arch.clean.pedidos.application.usecases;

import java.math.BigDecimal;

/**
 * La clase PedidoOutput representa la salida de la operación de realizar un pedido.
 * Contiene información sobre el ID del pedido, su estado y el total del pedido.
 */
public class PedidoOutput {
    private Long pedidoId;
    private String estado;
    private BigDecimal total;

    // Constructor, Getters y Setters
    public PedidoOutput(Long pedidoId, String estado, BigDecimal total) {
        this.pedidoId = pedidoId;
        this.estado = estado;
        this.total = total;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public String getEstado() {
        return estado;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
