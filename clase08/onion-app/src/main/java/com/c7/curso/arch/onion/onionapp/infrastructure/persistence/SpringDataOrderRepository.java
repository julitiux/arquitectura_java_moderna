package com.c7.curso.arch.onion.onionapp.infrastructure.persistence;

import com.c7.curso.arch.onion.onionapp.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataOrderRepository extends JpaRepository<Order, Long> {
}
