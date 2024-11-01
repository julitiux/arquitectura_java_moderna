package com.c7.courses.arch.eda.pedido.domain.service;

import com.c7.courses.arch.eda.pedido.command.CrearPedidoCommand;
import com.c7.courses.arch.eda.pedido.domain.model.Pedido;
import com.c7.courses.arch.eda.pedido.domain.repository.EventStore;

/**
 * La interfaz PedidoCommandService define los métodos para gestionar pedidos en un sistema.
 * Proporciona funcionalidades para crear y confirmar pedidos,
 * así como para reconstruir un pedido desde eventos almacenados.
 */
public interface PedidoCommandService {
    /**
     * Crea un nuevo pedido utilizando la información proporcionada en el comando CrearPedidoCommand.
     *
     * @param command El comando que contiene la información necesaria para crear un pedido, incluyendo el ID del pedido y el ID del cliente asociado.
     */
    void crearPedido(CrearPedidoCommand command);

    /**
     * Confirma un pedido existente basado en el ID del pedido proporcionado.
     * Este método actualiza el estado del pedido a confirmado, aplicando
     * los cambios necesarios y registrando el evento correspondiente.
     *
     * @param pedidoId El ID del pedido que se va a confirmar.
     */
    void confirmarPedido(String pedidoId);

    /**
     * Reconstruye un pedido a partir de eventos almacenados en un EventStore.
     *
     * @param eventStore el almacén de eventos de donde se obtendrán los eventos relacionados con el pedido.
     * @param pedidoId   el identificador del pedido que se va a reconstruir.
     * @return el pedido reconstruido a partir de los eventos obtenidos.
     */
    default Pedido reconstruirPedidoDesdeEventos(EventStore eventStore, String pedidoId) {
        var eventos = eventStore.obtenerEventos("pedido", pedidoId);

        var pedido = new Pedido(); // Reconstruir desde eventos
        eventos.forEach(pedido::aplicar);

        return pedido;
    }
}
