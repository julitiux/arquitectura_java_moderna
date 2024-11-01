package com.c7.courses.arch.eda.pedido.domain.model;

import com.c7.courses.arch.eda.event.Evento;
import com.c7.courses.arch.eda.event.EventoUtil;
import com.c7.courses.arch.eda.event.PedidoConfirmadoEvent;
import com.c7.courses.arch.eda.event.PedidoCreadoEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;

/**
 * La clase Pedido representa un pedido en un sistema de gestión de pedidos.
 * Cada pedido está asociado a un cliente y puede ser confirmado.
 * Se basa en un sistema de eventos para manejar la creación y confirmación del pedido.
 */
public class Pedido {
    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(Pedido.class);


    private String pedidoId;
    private String clienteId;
    private boolean esConfirmado;
    private List<Evento> eventos = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(String pedidoId, String clienteId) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        agregarEvento(new PedidoCreadoEvent(EventoUtil.generateRandomEventId(), pedidoId, clienteId));
    }

    /**
     * Confirma el pedido actual si no está ya confirmado.
     * <p>
     * Si el pedido ya ha sido confirmado previamente, se lanzará una excepción IllegalStateException.
     * Al confirmar el pedido, se genera y se agrega un evento de tipo PedidoConfirmadoEvent
     * con un identificador único, y el estado del pedido se actualiza a confirmado.
     *
     * @throws IllegalStateException si el pedido ya ha sido confirmado
     */
    public void confirmarPedido() {
        if (esConfirmado) {
            throw new IllegalStateException("El pedido ya está confirmado.");
        }
        agregarEvento(new PedidoConfirmadoEvent(EventoUtil.generateRandomEventId(), pedidoId));
        this.esConfirmado = true;
    }

    private void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    /**
     * Aplica un evento al pedido actual. Dependiendo del tipo de evento recibido,
     * delega el procesamiento al método correspondiente.
     *
     * @param evento El evento que se va a aplicar. Puede ser de tipo PedidoCreadoEvent
     *               o PedidoConfirmadoEvent.
     * @return true si el evento se aplicó correctamente, false en caso contrario.
     * @throws UnsupportedOperationException si el tipo de evento no es soportado.
     */
    public boolean aplicar(Evento evento) {
        logger.info("Aplicando Evento {}", evento);
        eventos.add(evento);
        return switch (evento) {
            case PedidoCreadoEvent pedidoCreado -> this.aplicar(pedidoCreado);
            case PedidoConfirmadoEvent pedidoConfirmado -> this.aplicar(pedidoConfirmado);
            default -> throw new UnsupportedOperationException("Evento no soportado");
        };
    }

    private boolean aplicar(PedidoCreadoEvent evento) {
        this.clienteId = evento.getClienteId();
        this.pedidoId = evento.getEntityId();
        return true;
    }

    private boolean aplicar(PedidoConfirmadoEvent evento) {
        if (Objects.equals(evento.getEntityId(), this.pedidoId)) {
            this.esConfirmado = true;
            return true;
        }
        logger.error("Error al confirmar el pedido.");
        return false;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public boolean isEsConfirmado() {
        return esConfirmado;
    }
}
