package com.c7.course.arch.clean.pedidos.application;

import java.util.List;

/**
 * La clase PedidoInput representa la información necesaria para realizar un pedido.
 * Contiene el ID del cliente que realiza el pedido, una lista de IDs de productos
 * que se desean adquirir, y el método de pago que se utilizará para procesar el pedido.
 */
public class PedidoInput {
    private Long clienteId;
    private List<Long> productosIds;
    private String metodoPago;

    // Constructor, Getters y Setters
    public PedidoInput(Long clienteId, List<Long> productosIds, String metodoPago) {
        this.clienteId = clienteId;
        this.productosIds = productosIds;
        this.metodoPago = metodoPago;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public List<Long> getProductosIds() {
        return productosIds;
    }

    public String getMetodoPago() {
        return metodoPago;
    }
}
