package com.c7.curso.arch.ddd.servicio;

import com.c7.curso.arch.ddd.dominio.cliente.ClienteId;
import com.c7.curso.arch.ddd.dominio.orden.Orden;
import com.c7.curso.arch.ddd.dominio.orden.OrdenId;
import com.c7.curso.arch.ddd.dominio.orden.OrdenRepository;
import com.c7.curso.arch.ddd.dominio.producto.Producto;
import org.jmolecules.ddd.annotation.Service;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Service
@Component
public class ServicioOrden {
    private final OrdenRepository ordenRepository;
    private final ApplicationEventPublisher eventPublisher;

    public ServicioOrden(OrdenRepository ordenRepository, ApplicationEventPublisher eventPublisher) {
        this.ordenRepository = ordenRepository;
        this.eventPublisher = eventPublisher;
    }

    public void realizarOrden(ClienteId clienteId, Producto producto, int cantidad) {
        Orden nuevaOrden = new Orden(new OrdenId(), clienteId, eventPublisher, ordenRepository);
        nuevaOrden.agregarItem(producto, cantidad);
        nuevaOrden.guardar();
    }

    public void completarOrden(OrdenId ordenId) {

        Orden orden = ordenRepository.findById(ordenId)
                .orElseThrow(() -> new IllegalArgumentException("Orden no encontrada"));
        orden.completar();
        ordenRepository.save(orden);
    }
}
