package com.c7.curso.arch.hexagonal.infraestructura.salida.repositorio;

import com.c7.curso.arch.hexagonal.dominio.modelo.Pedido;
import com.c7.curso.arch.hexagonal.dominio.repositorio.PedidoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepositoryJpa implements PedidoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Pedido pedido) {
        entityManager.persist(pedido);
    }

    @Override
    public Pedido buscarPorId(Long pedidoId) {
        return entityManager.find(Pedido.class, pedidoId);
    }

    @Override
    public void actualizar(Pedido pedido) {
        entityManager.merge(pedido);
    }
}

