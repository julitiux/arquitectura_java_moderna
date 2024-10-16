package com.c7.curso.arch.ddd.dominio.eventos;

import com.c7.curso.arch.ddd.dominio.orden.OrdenId;
import lombok.Getter;
import org.jmolecules.event.annotation.DomainEvent;


@Getter
@DomainEvent
public class OrdenCompletada {
    private final OrdenId ordenId;

    public OrdenCompletada(OrdenId ordenId) {
        this.ordenId = ordenId;
    }

}
