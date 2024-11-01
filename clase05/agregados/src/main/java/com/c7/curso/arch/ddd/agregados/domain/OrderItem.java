package com.c7.curso.arch.ddd.agregados.domain;

import java.util.UUID;

public class OrderItem {
    private final UUID itemId;
    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {
        this.itemId = UUID.randomUUID(); // Genera un ID único para el artículo del pedido
        this.product = product;
        this.quantity = quantity;
    }

    public UUID getItemId() {
        return itemId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

