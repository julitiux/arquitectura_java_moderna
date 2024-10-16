package com.c7.curso.arch.ddd.listeners;

import com.c7.curso.arch.ddd.dominio.eventos.OrdenCompletada;
import org.jmolecules.event.annotation.DomainEventHandler;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrdenCompletadaListener {

    @EventListener
    @DomainEventHandler
    public void handleOrdenCompletada(OrdenCompletada evento) {
        System.out.println("Orden completada: " + evento.getOrdenId());
    }
}
