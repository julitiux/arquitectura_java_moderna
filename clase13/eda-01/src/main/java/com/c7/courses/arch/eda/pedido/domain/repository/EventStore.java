package com.c7.courses.arch.eda.pedido.domain.repository;

import com.c7.courses.arch.eda.event.Evento;
import java.util.List;

/**
 * La interfaz EventStore define los métodos necesarios para manejar eventos en un sistema de almacenamiento de eventos.
 * Proporciona funcionalidades para guardar y obtener eventos asociados a una entidad específica.
 */
public interface EventStore {
    /**
     * Guarda una lista de eventos asociados a una entidad específica en el sistema de almacenamiento de eventos.
     *
     * @param entity   El nombre de la entidad a la que están asociados los eventos. Por ejemplo, "pedido".
     * @param entityId El identificador único de la entidad. Por ejemplo, el identificador de un pedido específico.
     * @param eventos  La lista de eventos a guardar en el sistema de almacenamiento. Estos eventos deben estar relacionados
     *                 con la entidad especificada.
     */
    void guardarEventos(String entity, String entityId, List<Evento> eventos);

    /**
     * Obtiene una lista de eventos asociados a una entidad específica en el sistema de almacenamiento de eventos.
     *
     * @param entity   El nombre de la entidad a la que están asociados los eventos. Por ejemplo, "pedido".
     * @param entityId El identificador único de la entidad. Por ejemplo, el identificador de un pedido específico.
     * @return Una lista de eventos relacionados con la entidad especificada.
     */
    List<Evento> obtenerEventos(String entity, String entityId);
}
