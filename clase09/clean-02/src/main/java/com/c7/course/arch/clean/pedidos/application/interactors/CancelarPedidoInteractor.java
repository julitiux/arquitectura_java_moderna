package com.c7.course.arch.clean.pedidos.application.interactors;

import com.c7.course.arch.clean.pedidos.application.exceptions.PedidoNoCancelableException;
import com.c7.course.arch.clean.pedidos.application.usecases.CancelarPedidoUseCase;
import com.c7.course.arch.clean.pedidos.domain.Pedido;
import com.c7.course.arch.clean.pedidos.domain.repository.PedidoRepository;

public class CancelarPedidoInteractor implements CancelarPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public CancelarPedidoInteractor(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void cancelarPedido(Long pedidoId) throws PedidoNoCancelableException {
        // 1. Obtener el pedido
        Pedido pedido = pedidoRepository.obtenerPedidoPorId(pedidoId)
                .orElseThrow(() -> new PedidoNoCancelableException("El pedido no existe."));

        // 2. Cancelar el pedido
        pedido.cancelar();

        // 3. Actualizar el estado del pedido
        pedidoRepository.actualizarPedido(pedido);
    }
}
