package com.c7.courses.arch.eda.event;

/**
 * Esta interfaz representa un evento genérico en un sistema de manejo de eventos.
 * Los eventos son identificables por su ID de evento y están categorizados por un tipo de evento.
 * Además, cada evento está asociado con una entidad particular cuya información relevante también se provee.
 */
public interface Evento {
    /**
     * Obtiene el ID único del evento.
     *
     * @return el ID del evento.
     */
    String getEventId();

    /**
     * Obtiene el tipo de evento.
     *
     * @return el tipo de evento.
     */
    String getEventType();

    /**
     * Obtiene el ID de la entidad asociada con el evento.
     *
     * @return el ID de la entidad.
     */
    String getEntityId();

    /**
     * Obtiene el nombre de la entidad asociada con el evento.
     *
     * @return el nombre de la entidad.
     */
    String getEntityName();
}
