package com.c7.course.arch.clean.pedidos.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * La clase Pedido representa una orden de compra realizada por un cliente.
 * Contiene la información necesaria para procesar y gestionar un pedido,
 * incluyendo el identificador del cliente, la lista de productos, el total del pedido
 * y el estado actual del mismo.
 */
public class Pedido {
    private Long id;
    private Long clienteId;
    private List<Producto> productos;
    private BigDecimal total;
    private String estado;

    public Pedido(Long clienteId, List<Producto> productos) {
        this.clienteId = clienteId;
        this.productos = productos;
        this.estado = "PENDIENTE";
        calcularTotal();
    }

    public Pedido(Long id, Long clienteId, List<Producto> productos) {
        this(clienteId, productos);
        this.id = id;
    }

    private void calcularTotal() {
        total = productos.stream()
                .map(Producto::getPrecio)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void confirmar() {
        this.estado = "CONFIRMADO";
    }

    public boolean esCancelable() {
        return "PENDIENTE".equals(this.estado);
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }
}
