package com.c7.curso.arch.onion.onionapp.domain.repository;

import com.c7.curso.arch.onion.onionapp.domain.entity.Order;

import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(Long id);

    Order save(Order order);
}
