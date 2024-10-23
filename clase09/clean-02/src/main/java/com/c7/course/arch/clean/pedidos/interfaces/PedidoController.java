package com.c7.course.arch.clean.pedidos.interfaces;

import com.c7.course.arch.clean.pedidos.application.usecases.CancelarPedidoUseCase;
import com.c7.course.arch.clean.pedidos.application.usecases.PedidoInput;
import com.c7.course.arch.clean.pedidos.application.exceptions.PedidoInvalidoException;
import com.c7.course.arch.clean.pedidos.application.usecases.PedidoOutput;
import com.c7.course.arch.clean.pedidos.application.usecases.RealizarPedidoUseCase;
import com.c7.course.arch.clean.pedidos.application.exceptions.PedidoNoCancelableException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RealizarPedidoUseCase realizarPedidoUseCase;
    private final CancelarPedidoUseCase cancelarPedidoUseCase;

    public PedidoController(
            RealizarPedidoUseCase realizarPedidoUseCase,
            CancelarPedidoUseCase cancelarPedidoUseCase
    ) {
        this.realizarPedidoUseCase = realizarPedidoUseCase;
        this.cancelarPedidoUseCase = cancelarPedidoUseCase;
    }

    @PostMapping
    public ResponseEntity<?> realizarPedido(@RequestBody PedidoInput input) {
        try {
            PedidoOutput output = realizarPedidoUseCase.realizarPedido(input);
            return ResponseEntity.ok(output);
        } catch (PedidoInvalidoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{pedidoId}")
    public ResponseEntity<String> cancelarPedido(@PathVariable Long pedidoId) {
        try {
            cancelarPedidoUseCase.cancelarPedido(pedidoId);
            return ResponseEntity.ok("Pedido cancelado con éxito.");
        } catch (PedidoNoCancelableException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
