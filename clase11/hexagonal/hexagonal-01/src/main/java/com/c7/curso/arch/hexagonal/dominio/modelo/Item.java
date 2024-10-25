package com.c7.curso.arch.hexagonal.dominio.modelo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * La clase Item representa un artículo que puede ser parte de un pedido en el sistema de compra.
 * Esta clase contiene información sobre el artículo como su identificador, nombre y precio.
 *
 * Propiedades principales:
 *
 * - id: Identificador único del artículo.
 * - nombre: Nombre descriptivo del artículo.
 * - precio: Precio del artículo, representado como BigDecimal.
 *
 * Métodos de acceso: Esta clase utiliza las anotaciones @Getter y @Setter de Lombok para
 * generar automáticamente los métodos de acceso (getters y setters) necesarios para sus propiedades.
 */
@Getter
@Setter
public class Item {
    private Long id;
    private String nombre;
    private BigDecimal precio;
}
