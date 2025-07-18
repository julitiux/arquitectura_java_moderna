package com.c7.curso.arch.ddd.agregados.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID orderId;
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status;
    private final Customer customer;

    public Order(Customer customer) {
        this.orderId = UUID.randomUUID(); // Genera un ID único para el pedido
        this.status = OrderStatus.NEW;    // El pedido comienza en estado "Nuevo"
        this.customer = customer;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Método para agregar un artículo al pedido
    public void addItem(Product product, int quantity) {
        OrderItem item = new OrderItem(product, quantity);
        this.items.add(item);
    }

    // Método para quitar un artículo del pedido
    public void removeItem(UUID itemId) {
        this.items.removeIf(item -> item.getItemId().equals(itemId));
    }

    // Método para marcar el pedido como confirmado
    public void confirmOrder() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Order cannot be confirmed with no items.");
        }
        this.status = OrderStatus.CONFIRMED;
    }

    // Método para cancelar el pedido
    public void cancelOrder() {
        this.status = OrderStatus.CANCELLED;
    }
}

