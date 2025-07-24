package com.c7.curso.arch.ddd.dominio.orden;

import org.jmolecules.ddd.annotation.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface OrdenRepository extends CrudRepository<Orden, OrdenId> {
}
