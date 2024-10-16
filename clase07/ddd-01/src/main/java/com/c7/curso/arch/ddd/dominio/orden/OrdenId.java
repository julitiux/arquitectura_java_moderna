package com.c7.curso.arch.ddd.dominio.orden;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

import java.io.Serializable;

@Getter
@ValueObject
public class OrdenId implements Serializable {
    private final Long id;

    public OrdenId() {
        this.id = System.currentTimeMillis(); // Genera un ID simple para el ejemplo
    }

    public OrdenId(Long id) {
        this.id = id;
    }

}
