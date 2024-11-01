package com.c7.courses.arch.eda.pedido.projections;

/**
 * La clase PedidoView representa la vista de un pedido, proporcionando detalles
 * esenciales como el identificador del pedido, el identificador del cliente y el
 * estado de confirmación del pedido.
 */
public class PedidoView {
    private String pedidoId;
    private String clienteId;
    private boolean esConfirmado;

    public PedidoView(String pedidoId, String clienteId, boolean esConfirmado) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.esConfirmado = esConfirmado;
    }

    public boolean isEsConfirmado() {
        return esConfirmado;
    }

    public void setEsConfirmado(boolean esConfirmado) {
        this.esConfirmado = esConfirmado;
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
