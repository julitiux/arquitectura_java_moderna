package com.c7.course.arch.clean.pedidos.infrastructure.repositories;

import jakarta.persistence.*;

@Entity
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long clienteId;
    @Column(nullable = false)
    private String estado;

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
