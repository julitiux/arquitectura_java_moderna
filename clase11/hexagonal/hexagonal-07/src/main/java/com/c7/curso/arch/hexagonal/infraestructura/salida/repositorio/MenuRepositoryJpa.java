package com.c7.curso.arch.hexagonal.infraestructura.salida.repositorio;

import com.c7.curso.arch.hexagonal.dominio.modelo.Menu;
import com.c7.curso.arch.hexagonal.dominio.repositorio.MenuRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MenuRepositoryJpa implements MenuRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Menu buscarPorRestauranteId(Long restauranteId) {
        return entityManager.find(Menu.class, restauranteId);
    }

    @Override
    public void actualizar(Menu menu) {
        entityManager.merge(menu);
    }
}

