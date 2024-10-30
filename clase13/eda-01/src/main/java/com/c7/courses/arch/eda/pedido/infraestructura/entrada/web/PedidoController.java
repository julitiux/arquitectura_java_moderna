package com.c7.courses.arch.eda.pedido.infraestructura.entrada.web;

import com.c7.courses.arch.eda.pedido.aplicacion.servicio.PedidoQueryService;
import com.c7.courses.arch.eda.pedido.command.CrearPedidoCommand;
import com.c7.courses.arch.eda.pedido.domain.service.PedidoCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {
    private final PedidoQueryService pedidoQueryService;
    private final PedidoCommandService pedidoCommandService;

    public PedidoController(PedidoQueryService pedidoQueryService, PedidoCommandService pedidoCommandService) {
        this.pedidoQueryService = pedidoQueryService;
        this.pedidoCommandService = pedidoCommandService;
    }

    @GetMapping("/pedidos/{pedidoId}")
    public ResponseEntity<?> obtenerPedido(@PathVariable("pedidoId") String pedidoId) {
        return pedidoQueryService.obtenerPedido(pedidoId)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/pedidos/")
    public String crearPedido(@RequestBody CrearPedidoCommand command) {
        pedidoCommandService.crearPedido(command);
        return "true";
    }

    @PutMapping("/pedidos/{pedidoId}")
    public String confirmarPedido(@PathVariable("pedidoId") String pedidoId) {
        pedidoCommandService.confirmarPedido(pedidoId);
        return "true";
    }
}
