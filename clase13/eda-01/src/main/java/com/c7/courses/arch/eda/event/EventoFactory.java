package com.c7.courses.arch.eda.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class EventoFactory {
    private static final TypeReference<HashMap<String, Object>> typeRef
        = new TypeReference<HashMap<String, Object>>() {
    };
    public static Map<String, Object> fromJsonAsMap(ObjectMapper jsonMapper, String json) {
        try {
            return jsonMapper.readValue(json, typeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public static Evento fromJson(ObjectMapper jsonMapper, String json) {
        System.out.println("Json de Evento: " + json);
        try {
            final var jsonAsMap = jsonMapper.readValue(json, typeRef);
            if (jsonAsMap.containsKey("entityName")) {
                Object objectEntityName = jsonAsMap.get("entityName");
                Object objectEventType = jsonAsMap.get("eventType");
                Object objectEntityId = jsonAsMap.get("entityId");
                if (objectEntityName instanceof String entityName &&
                    objectEventType instanceof String eventType &&
                    objectEntityId instanceof String entityId) {
                    return EventoFactory.buildEvent(entityName, eventType, jsonAsMap);
                } else {
                    throw new IllegalArgumentException("No se encontraron los campos necesarios en el json: " + json);
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Evento buildEvent(String entityName, String eventType, HashMap<String, Object> jsonAsMap) {
        switch (entityName) {
            case "pedido":
                return EventoFactory.buildPedidoEvent(eventType, jsonAsMap);
            default:
                throw new UnsupportedOperationException("La entidad" + entityName + " no esta soportada");
        }
    }

    public static Evento buildPedidoEvent(String eventType, HashMap<String, Object> jsonAsMap) {
        return switch (eventType) {
            case "pedidoCreado" -> EventoFactory.pedidoCreadoFrom(jsonAsMap);
            case "pedidoConfirmado" -> EventoFactory.pedidoConfirmadoFrom(jsonAsMap);
            default -> throw new UnsupportedOperationException("Tipo de pedido no soportado: " + eventType);
        };
    }

    public static PedidoCreadoEvent pedidoCreadoFrom(Map<String, Object> data) {
        String eventId = (String) data.get("eventId");
        String entityId = (String) data.get("entityId");
        String clienteId = (String) data.get("clienteId");
        return new PedidoCreadoEvent(eventId, entityId, clienteId);
    }

    public static PedidoConfirmadoEvent pedidoConfirmadoFrom(Map<String, Object> data) {
        String eventId = (String) data.get("eventId");
        String entityId = (String) data.get("entityId");
        return new PedidoConfirmadoEvent(eventId, entityId);
    }
}
