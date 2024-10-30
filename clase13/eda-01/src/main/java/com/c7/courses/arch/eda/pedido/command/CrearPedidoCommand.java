package com.c7.courses.arch.eda.pedido.command;

/**
 * La clase CrearPedidoCommand representa un comando para crear un nuevo pedido en el sistema.
 * <p>
 * Esta clase contiene la información esencial para realizar la operación de creación de un pedido,
 * incluyendo el ID del pedido y el ID del cliente asociado.
 */
public class CrearPedidoCommand {
    private String pedidoId;
    private String clienteId;

    public CrearPedidoCommand() {
    }

    public CrearPedidoCommand(String pedidoId, String clienteId) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }
}

