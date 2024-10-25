package com.c7.curso.arch.hexagonal.infraestructura.salida.repositorio;

import com.c7.curso.arch.hexagonal.dominio.modelo.Item;
import com.c7.curso.arch.hexagonal.dominio.repositorio.ItemRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryJpa implements ItemRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings( "unchecked")
    @Override
    public List<Item> findItems(List<Long> ids) {
        return entityManager
            .createQuery("select i from Item where i.id in :ids")
            .setParameter("ids", ids)
            .getResultList();
    }
}
