package com.c7.curso.arch.onion.onionapp.infrastructure.persistence;

import com.c7.curso.arch.onion.onionapp.domain.entity.Order;
import com.c7.curso.arch.onion.onionapp.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {

    private final SpringDataOrderRepository repository;

    public JpaOrderRepository(SpringDataOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }
}
