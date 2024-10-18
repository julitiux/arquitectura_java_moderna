package com.c7.curso.arch.onion.onionapp.domain.service;

import com.c7.curso.arch.onion.onionapp.domain.entity.Order;
import com.c7.curso.arch.onion.onionapp.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDomainService {

    private final OrderRepository orderRepository;

    public OrderDomainService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }
}
