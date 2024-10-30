package com.c7.courses.arch.eda.event;

/**
 * PedidoConfirmadoEvent representa un evento que indica que un pedido ha sido confirmado.
 * Este evento contiene la información necesaria para identificar el evento, el pedido
 * asociado y los detalles inherentes al tipo de evento y la entidad a la que se refiere.
 *
 * Implementa la interfaz Evento, lo que permite manejar este evento de una manera polimórfica
 * junto con otros tipos de eventos que siguen la misma estructura.
 *
 * Campos:
 * - id: Identificador único del evento.
 * - pedidoId: Identificador del pedido asociado con este evento.
 * - entityName: Constante que representa el nombre de la entidad ("pedido").
 * - eventType: Constante que representa el tipo de evento ("pedidoConfirmado").
 *
 * Métodos:
 * - PedidoConfirmadoEvent(String eventId, String pedidoId): Constructor que inicializa el evento con los IDs correspondientes.
 * - String getEventId(): Obtiene el identificador único del evento.
 * - String getEventType(): Obtiene el tipo del evento.
 * - String getEntityId(): Obtiene el identificador del pedido asociado con el evento.
 * - String getEntityName(): Obtiene el nombre de la entidad asociada con el evento.
 * - String toString(): Devuelve una representación en forma de cadena de este evento.
 */
public class PedidoConfirmadoEvent implements Evento {
    private final String id;
    private final String pedidoId;

    private final String entityName = "pedido";
    private final String eventType = "pedidoConfirmado";

    public PedidoConfirmadoEvent(String eventId, String pedidoId) {
        this.id = eventId;
        this.pedidoId = pedidoId;
    }

    @Override
    public String getEventId() {
        return id;
    }

    @Override
    public String getEventType() {
        return this.eventType;
    }

    @Override
    public String getEntityId() {
        return pedidoId;
    }

    @Override
    public String getEntityName() {
        return this.entityName;
    }

    @Override
    public String toString() {
        return "PedidoConfirmadoEvent{" +
                "id='" + id + '\'' +
                ", pedidoId='" + pedidoId + '\'' +
                ", entityName='" + entityName + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
