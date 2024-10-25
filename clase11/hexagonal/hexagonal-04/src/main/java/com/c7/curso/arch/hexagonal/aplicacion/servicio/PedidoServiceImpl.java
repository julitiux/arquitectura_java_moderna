package com.c7.curso.arch.hexagonal.aplicacion.servicio;

import com.c7.curso.arch.hexagonal.dominio.gateway.NotificationService;
import com.c7.curso.arch.hexagonal.dominio.gateway.PaymentGateway;
import com.c7.curso.arch.hexagonal.dominio.modelo.EstadoPedido;
import com.c7.curso.arch.hexagonal.dominio.modelo.Item;
import com.c7.curso.arch.hexagonal.dominio.modelo.Pedido;
import com.c7.curso.arch.hexagonal.dominio.repositorio.ItemRepository;
import com.c7.curso.arch.hexagonal.dominio.repositorio.PedidoRepository;
import com.c7.curso.arch.hexagonal.dominio.servicio.PedidoService;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 * La clase PedidoServiceImpl implementa la interfaz PedidoService y proporciona
 * la lógica para crear y pagar pedidos.
 * Utiliza PedidoRepository para persistencia, PaymentGateway para procesamiento de pagos,
 * y NotificationService para notificaciones.
 */
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ItemRepository itemRepository;
    private final PaymentGateway paymentGateway;
    private final NotificationService notificationService;

    @Override
    public Pedido crearPedido(Long usuarioId, List<Item> items, String direccionEntrega) {
        Pedido pedido = new Pedido(usuarioId, items, direccionEntrega);
        pedidoRepository.guardar(pedido);
        notificationService.notificarPedidoCreado(pedido);
        return pedido;
    }

    @Override
    public Pedido crearPedido(Long usuarioId, String direccionEntrega, List<Long> items) {
        return crearPedido(usuarioId, itemRepository.findItems(items), direccionEntrega);
    }

    @Override
    public void pagarPedido(Long pedidoId) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);
        paymentGateway.procesarPago(pedido);
        pedido.pagar();
        pedidoRepository.actualizar(pedido);
    }

    @Override
    public void asignarPedidoARepartidor(Long pedidoId, Long repartidorId) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);

        if (pedido.getEstado() != EstadoPedido.LISTO_PARA_RECOGER) {
            throw new IllegalStateException("El pedido no está listo para ser recogido.");
        }

        pedido.asignarRepartidor(repartidorId);
        pedido.cambiarEstado(EstadoPedido.EN_CAMINO);
        pedidoRepository.actualizar(pedido);

        notificationService.notificarAsignacionPedido(pedido, repartidorId);
    }

    @Override
    public void completarEntrega(Long pedidoId, Long repartidorId) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId);

        if (pedido.getRepartidorId().equals(repartidorId) && pedido.getEstado() == EstadoPedido.EN_CAMINO) {
            pedido.cambiarEstado(EstadoPedido.ENTREGADO);
            pedidoRepository.actualizar(pedido);
            notificationService.notificarEntregaCompletada(pedido);
        } else {
            throw new IllegalStateException("El pedido no puede ser marcado como entregado en su estado actual.");
        }
    }
}
