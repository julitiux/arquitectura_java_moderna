package com.c7.courses.arch.eda.pedido.infraestructura.salida.repository;

import com.c7.courses.arch.eda.pedido.infraestructura.salida.repository.entity.JpaEntityEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaEntityEventRepository extends CrudRepository<JpaEntityEvent, String> {
    List<JpaEntityEvent> findAllByEntityNameAndEntityIdOrderByCreatedAt(String entityName, String entityId);
}
