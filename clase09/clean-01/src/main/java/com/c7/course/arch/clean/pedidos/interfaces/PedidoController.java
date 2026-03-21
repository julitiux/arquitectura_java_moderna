package com.c7.course.arch.clean.pedidos.interfaces;

import com.c7.course.arch.clean.pedidos.application.PedidoInput;
import com.c7.course.arch.clean.pedidos.application.PedidoInvalidoException;
import com.c7.course.arch.clean.pedidos.application.PedidoOutput;
import com.c7.course.arch.clean.pedidos.application.RealizarPedidoUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RealizarPedidoUseCase realizarPedidoUseCase;

    public PedidoController(RealizarPedidoUseCase realizarPedidoUseCase) {
        this.realizarPedidoUseCase = realizarPedidoUseCase;
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
}
