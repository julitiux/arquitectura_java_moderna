package com.c7.curso.arch.hexagonal.infraestructura.entrada.controlador;

import com.c7.curso.arch.hexagonal.dominio.servicio.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody CrearPedidoCommand command) {
        return ResponseEntity.ok(
            pedidoService.crearPedido(
                command.getUsuarioId(),
                command.getDireccionEntrega(),
                command.getItemsId())
        );
    }

    @PutMapping("/{pedidoId}")
    public ResponseEntity<Void> pagarPedido(@PathVariable Long pedidoId) {
        pedidoService.pagarPedido(pedidoId);
        return ResponseEntity.noContent().build();
    }
}
