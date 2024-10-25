package com.c7.curso.arch.hexagonal.dominio.modelo;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetallesPago {
    private String numeroTarjeta;
    private String nombreTitular;
    private String fechaExpiracion;
    private String codigoSeguridad;
    private BigDecimal monto;
}
