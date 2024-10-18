package com.c7.curso.arch.onion.onionapp.infrastructure.web;

import com.c7.curso.arch.onion.onionapp.application.service.OrderApplicationService;
import com.c7.curso.arch.onion.onionapp.domain.entity.Order;
import com.c7.curso.arch.onion.onionapp.domain.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping
    public Order createOrder(@RequestBody List<Product> products) {
        Order order = new Order(null, products);
        return orderApplicationService.createNewOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderApplicationService.findOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }
}
