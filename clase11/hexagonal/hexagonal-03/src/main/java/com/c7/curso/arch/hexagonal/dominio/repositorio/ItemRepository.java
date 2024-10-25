package com.c7.curso.arch.hexagonal.dominio.repositorio;

import com.c7.curso.arch.hexagonal.dominio.modelo.Item;
import java.util.List;

public interface ItemRepository {
    List<Item> findItems(List<Long> ids);

}
