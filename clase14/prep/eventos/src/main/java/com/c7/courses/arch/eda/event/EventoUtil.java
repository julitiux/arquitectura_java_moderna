package com.c7.courses.arch.eda.event;

import java.util.UUID;

/**
 * Utilidad para generar identificadores únicos para eventos.
 * Esta clase proporciona métodos para la creación de identificadores de eventos
 * de forma aleatoria, asegurando que cada identificador sea único.
 */
public class EventoUtil {
    /**
     * Genera un identificador único de evento de forma aleatoria.
     *
     * @return un identificador único para un evento en formato de cadena.
     */
    public static String generateRandomEventId() {
        return UUID.randomUUID().toString();
    }
}
