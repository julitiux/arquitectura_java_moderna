package com.c7.curso.arch.hexagonal.dominio.modelo;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Menu {
    private Long restauranteId;
    private List<ItemMenu> items;

    public Menu(Long restauranteId) {
        this.restauranteId = restauranteId;
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemMenu item) {
        items.add(item);
    }

    public void actualizarItem(ItemMenu item) {
        items = items.stream()
            .map(existingItem -> existingItem.getId().equals(item.getId()) ? item : existingItem)
            .toList();
    }

    public void eliminarItem(Long itemId) {
        items.removeIf(item -> item.getId().equals(itemId));
    }
}
