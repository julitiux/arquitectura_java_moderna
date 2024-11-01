package com.c7.curso.arch.ddd.agregados;

import com.c7.curso.arch.ddd.agregados.domain.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrderRepository {
    private final Map<UUID, Order> database = new HashMap<>();

    public void save(Order order) {
        database.put(order.getOrderId(), order);
    }

    public Order findById(UUID orderId) {
        return database.get(orderId);
    }
}

