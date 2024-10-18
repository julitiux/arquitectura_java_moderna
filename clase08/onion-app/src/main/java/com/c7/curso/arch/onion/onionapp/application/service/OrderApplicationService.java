package com.c7.curso.arch.onion.onionapp.application.service;

import com.c7.curso.arch.onion.onionapp.domain.entity.Order;
import com.c7.curso.arch.onion.onionapp.domain.service.OrderDomainService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderApplicationService {

    private final OrderDomainService orderDomainService;

    public OrderApplicationService(OrderDomainService orderDomainService) {
        this.orderDomainService = orderDomainService;
    }

    public Order createNewOrder(Order order) {
        return orderDomainService.createOrder(order);
    }

    public Optional<Order> findOrderById(Long id) {
        return orderDomainService.findOrderById(id);
    }
}
