package com.c7.course.arch.clean.pedidos.infrastructure.repositories;

import com.c7.course.arch.clean.pedidos.domain.Producto;
import com.c7.course.arch.clean.pedidos.domain.repository.ProductoRepository;

import java.util.List;

public class SpringDataProductoRepository implements ProductoRepository {
    private final JpaProductoRepository jpaProductoRepository;

    public SpringDataProductoRepository(JpaProductoRepository jpaProductoRepository) {
        this.jpaProductoRepository = jpaProductoRepository;
    }

    @Override
    public List<Producto> obtenerProductosPorIds(List<Long> productosIds) {
        return jpaProductoRepository.findAllById(productosIds)
                .stream()
                .map(productoEntity -> new Producto(
                        productoEntity.getId(),
                        productoEntity.getNombre(),
                        productoEntity.getPrecio())
                )
                .toList();
    }
}
