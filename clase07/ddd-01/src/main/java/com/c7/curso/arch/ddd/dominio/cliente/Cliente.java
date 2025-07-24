package com.c7.curso.arch.ddd.dominio.cliente;

import com.c7.curso.arch.ddd.dominio.orden.Orden;
import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.AggregateRoot;


import java.util.ArrayList;
import java.util.List;

@Getter
@AggregateRoot
public class Cliente {
    private final ClienteId id;
    private String nombre;
    private String correo;
    private List<Orden> ordenes;

    public Cliente(ClienteId id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.ordenes = new ArrayList<>();
    }

    public void realizarOrden(Orden orden) {
        this.ordenes.add(orden);
    }

}
