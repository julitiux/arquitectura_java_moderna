package com.c7.curso.arch.onion.onionapp.domain.entity;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Order {

    private Long id;
    private List<Product> products;
    private double totalPrice;

    public Order(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
        this.totalPrice = calculateTotalPrice();
    }

    private double calculateTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
