package com.c7.curso.arch.hexagonal.dominio.repositorio;

import com.c7.curso.arch.hexagonal.dominio.modelo.Menu;

public interface MenuRepository {
    Menu buscarPorRestauranteId(Long restauranteId);

    void actualizar(Menu menu);
}
