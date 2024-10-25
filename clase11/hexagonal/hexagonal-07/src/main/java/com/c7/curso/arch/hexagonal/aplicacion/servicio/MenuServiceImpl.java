package com.c7.curso.arch.hexagonal.aplicacion.servicio;

import com.c7.curso.arch.hexagonal.dominio.modelo.ItemMenu;
import com.c7.curso.arch.hexagonal.dominio.modelo.Menu;
import com.c7.curso.arch.hexagonal.dominio.repositorio.MenuRepository;
import com.c7.curso.arch.hexagonal.dominio.servicio.MenuService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    @Override
    public void agregarItem(Long restauranteId, ItemMenu item) {
        Menu menu = menuRepository.buscarPorRestauranteId(restauranteId);
        menu.agregarItem(item);
        menuRepository.actualizar(menu);
    }

    @Override
    public void actualizarItem(Long restauranteId, ItemMenu item) {
        Menu menu = menuRepository.buscarPorRestauranteId(restauranteId);
        menu.actualizarItem(item);
        menuRepository.actualizar(menu);
    }

    @Override
    public void eliminarItem(Long restauranteId, Long itemId) {
        Menu menu = menuRepository.buscarPorRestauranteId(restauranteId);
        menu.eliminarItem(itemId);
        menuRepository.actualizar(menu);
    }
}

