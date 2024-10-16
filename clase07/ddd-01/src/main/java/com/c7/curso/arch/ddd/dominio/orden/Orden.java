package com.c7.curso.arch.ddd.dominio.orden;


import com.c7.curso.arch.ddd.dominio.cliente.ClienteId;
import com.c7.curso.arch.ddd.dominio.eventos.OrdenCompletada;
import com.c7.curso.arch.ddd.dominio.producto.Producto;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.event.annotation.DomainEventPublisher;
import org.springframework.context.ApplicationEventPublisher;


import java.util.ArrayList;
import java.util.List;

@AggregateRoot
public class Orden {
    private final OrdenId id;
    private final ClienteId clienteId;
    private List<ItemOrden> items;
    private EstadoOrden estado;
    private ApplicationEventPublisher eventPublisher;
    private OrdenRepository ordenRepository;

    public Orden(OrdenId id, ClienteId clienteId, ApplicationEventPublisher eventPublisher, OrdenRepository ordenRepository) {
        this.id = id;
        this.clienteId = clienteId;
        this.ordenRepository = ordenRepository;
        this.items = new ArrayList<>();
        this.estado = EstadoOrden.PENDIENTE;
        this.eventPublisher = eventPublisher;
    }

    public void agregarItem(Producto producto, int cantidad) {
        ItemOrden item = new ItemOrden(producto, cantidad);
        items.add(item);
    }

    @DomainEventPublisher
    public void completar() {
        if (estado == EstadoOrden.PENDIENTE) {
            estado = EstadoOrden.COMPLETADA;
            // Publicar evento de dominio
            eventPublisher.publishEvent(new OrdenCompletada(id));
        } else {
            throw new IllegalStateException("La orden no se puede completar, ya está completada o cancelada.");
        }
    }

    public Orden guardar() {
        return ordenRepository.save(this);
    }
}
