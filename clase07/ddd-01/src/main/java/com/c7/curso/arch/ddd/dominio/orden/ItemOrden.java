package com.c7.curso.arch.ddd.dominio.orden;


import com.c7.curso.arch.ddd.dominio.producto.Producto;
import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@Getter
@ValueObject
public class ItemOrden {
    private final Producto producto;
    private final int cantidad;

    public ItemOrden(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double calcularTotal() {
        return producto.getPrecio() * cantidad;
    }
}
