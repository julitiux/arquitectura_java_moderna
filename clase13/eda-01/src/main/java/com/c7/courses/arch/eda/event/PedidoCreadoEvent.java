package com.c7.courses.arch.eda.event;

/**
 * La clase PedidoCreadoEvent representa un evento que se dispara cuando un pedido es creado en el sistema.
 * Implementa la interfaz Evento, lo que permite obtener información sobre el evento y la entidad asociada a él.
 */
public class PedidoCreadoEvent implements Evento {
    private final String eventId;
    private final String entityId;
    private final String clienteId;
    private final String entityName = "pedido";
    private final String eventType = "pedidoCreado";

    public PedidoCreadoEvent(String eventId, String pedidoId, String clienteId) {
        this.eventId = eventId;
        this.entityId = pedidoId;
        this.clienteId = clienteId;
    }

    public String getEntityId() {
        return entityId;
    }

    public String getClienteId() {
        return clienteId;
    }

    @Override
    public String getEventId() {
        return this.eventId;
    }

    @Override
    public String toString() {
        return "PedidoCreadoEvent{" +
            "eventId='" + eventId + '\'' +
            ", pedidoId='" + entityId + '\'' +
            ", clienteId='" + clienteId + '\'' +
            '}';
    }

    public String getEntityName() {
        return entityName;
    }

    public String getEventType() {
        return eventType;
    }
}
