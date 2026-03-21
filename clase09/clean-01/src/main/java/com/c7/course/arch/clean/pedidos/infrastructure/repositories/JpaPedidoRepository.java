package com.c7.course.arch.clean.pedidos.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
