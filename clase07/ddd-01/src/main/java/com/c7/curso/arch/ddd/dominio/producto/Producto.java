package com.c7.curso.arch.ddd.dominio.producto;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@Getter
@ValueObject
public class Producto {
    private final String codigo;
    private final String nombre;
    private final double precio;

    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
}
