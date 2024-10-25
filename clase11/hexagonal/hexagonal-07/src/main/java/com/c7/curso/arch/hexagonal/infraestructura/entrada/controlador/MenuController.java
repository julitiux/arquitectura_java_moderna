package com.c7.curso.arch.hexagonal.infraestructura.entrada.controlador;

import com.c7.curso.arch.hexagonal.dominio.modelo.ItemMenu;
import com.c7.curso.arch.hexagonal.dominio.servicio.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/items")
    public ResponseEntity<Void> agregarItem(@PathVariable Long restauranteId, @RequestBody ItemMenu item) {
        menuService.agregarItem(restauranteId, item);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/items")
    public ResponseEntity<Void> actualizarItem(@PathVariable Long restauranteId, @RequestBody ItemMenu item) {
        menuService.actualizarItem(restauranteId, item);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long restauranteId, @PathVariable Long itemId) {
        menuService.eliminarItem(restauranteId, itemId);
        return ResponseEntity.ok().build();
    }
}

