package com.c7.curso.arch.hexagonal.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemMenu {
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;

    public ItemMenu(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
