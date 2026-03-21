package com.c7.course.arch.clean.pedidos.domain.repository;

import com.c7.course.arch.clean.pedidos.domain.Producto;

import java.util.List;

/**
 * ProductoRepository es una interfaz que define las operaciones básicas
 * para la gestión de productos en el sistema. Provee métodos para obtener
 * productos basados en su identificación única.
 */
public interface ProductoRepository {
    /**
     * Obtiene una lista de productos según sus identificadores únicos.
     *
     * @param productosIds una lista de identificadores únicos de los productos a obtener.
     * @return una lista de objetos Producto que corresponden a los identificadores proporcionados.
     */
    List<Producto> obtenerProductosPorIds(List<Long> productosIds);
}
