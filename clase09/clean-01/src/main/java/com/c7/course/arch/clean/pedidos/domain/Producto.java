package com.c7.course.arch.clean.pedidos.domain;

import java.math.BigDecimal;

/**
 * La clase Producto representa un producto en el sistema.
 * Contiene información básica del producto como su identificador,
 * nombre y precio.
 */
public class Producto {
    private Long id;
    private String nombre;
    private BigDecimal precio;

    public Producto(Long id, String nombre, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public Long getId() {
        return id;
    }
}
