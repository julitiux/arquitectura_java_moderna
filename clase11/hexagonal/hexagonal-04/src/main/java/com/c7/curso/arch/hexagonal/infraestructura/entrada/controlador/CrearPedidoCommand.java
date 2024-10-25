package com.c7.curso.arch.hexagonal.infraestructura.entrada.controlador;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CrearPedidoCommand {
    private Long usuarioId;
    private String direccionEntrega;
    private List<Long> itemsId;
}
