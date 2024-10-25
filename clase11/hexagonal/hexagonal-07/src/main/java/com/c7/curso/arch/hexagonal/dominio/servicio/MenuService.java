package com.c7.curso.arch.hexagonal.dominio.servicio;

import com.c7.curso.arch.hexagonal.dominio.modelo.ItemMenu;

public interface MenuService {
    void agregarItem(Long restauranteId, ItemMenu item);

    void actualizarItem(Long restauranteId, ItemMenu item);

    void eliminarItem(Long restauranteId, Long itemId);
}

