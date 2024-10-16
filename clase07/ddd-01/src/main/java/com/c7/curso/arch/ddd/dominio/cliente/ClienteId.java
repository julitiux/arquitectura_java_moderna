package com.c7.curso.arch.ddd.dominio.cliente;

import lombok.Getter;
import org.jmolecules.ddd.annotation.ValueObject;

@Getter
@ValueObject
public class ClienteId {
    private final Long id;

    public ClienteId(Long id) {
        this.id = id;
    }

}
