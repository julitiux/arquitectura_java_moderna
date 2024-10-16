package com.c7.curso.arch.ddd.api;

import com.c7.curso.arch.ddd.dominio.cliente.ClienteId;
import com.c7.curso.arch.ddd.dominio.orden.OrdenId;
import com.c7.curso.arch.ddd.dominio.producto.Producto;
import com.c7.curso.arch.ddd.servicio.ServicioOrden;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class OrdenController {
    private final ServicioOrden servicioOrden;

    public OrdenController(ServicioOrden servicioOrden) {
        this.servicioOrden = servicioOrden;
    }

    @PostMapping("/")
    public void create(@RequestParam Long clienteId, @RequestBody Producto producto, @RequestParam int cantidad) {
        servicioOrden.realizarOrden(new ClienteId(clienteId), producto, cantidad);
    }

    @PostMapping("/{ordenId}")
    public void complete(@PathVariable Long ordenId) {
        servicioOrden.completarOrden(new OrdenId(ordenId));
    }
}
