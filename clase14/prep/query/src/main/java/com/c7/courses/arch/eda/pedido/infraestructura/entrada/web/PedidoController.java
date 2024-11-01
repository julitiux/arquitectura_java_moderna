package com.c7.courses.arch.eda.pedido.infraestructura.entrada.web;

import com.c7.courses.arch.eda.pedido.aplicacion.servicio.PedidoQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {
    private final PedidoQueryService pedidoQueryService;

    public PedidoController(PedidoQueryService pedidoQueryService) {
        this.pedidoQueryService = pedidoQueryService;
    }

    @GetMapping("/pedidos/{pedidoId}")
    public ResponseEntity<?> obtenerPedido(@PathVariable("pedidoId") String pedidoId) {
        return pedidoQueryService.obtenerPedido(pedidoId)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
