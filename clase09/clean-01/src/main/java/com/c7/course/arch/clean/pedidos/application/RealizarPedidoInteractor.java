package com.c7.course.arch.clean.pedidos.application;

import com.c7.course.arch.clean.pedidos.domain.Pedido;
import com.c7.course.arch.clean.pedidos.domain.Producto;
import com.c7.course.arch.clean.pedidos.domain.repository.PedidoRepository;
import com.c7.course.arch.clean.pedidos.domain.repository.ProductoRepository;

import java.util.List;

/**
 * La clase RealizarPedidoInteractor implementa la lógica de negocio
 * para realizar un pedido. Esta clase es responsable de gestionar el flujo
 * completo de creación de pedidos, desde la obtención de productos hasta
 * la confirmación y almacenamiento del pedido.
 */
public class RealizarPedidoInteractor implements RealizarPedidoUseCase {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;
    private final PagoService pagoService;

    public RealizarPedidoInteractor(
            PedidoRepository pedidoRepository,
            ProductoRepository productoRepository,
            PagoService pagoService
    ) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
        this.pagoService = pagoService;
    }

    @Override
    public PedidoOutput realizarPedido(PedidoInput input) throws PedidoInvalidoException {
        // 1. Obtener productos del repositorio
        List<Producto> productos = productoRepository.obtenerProductosPorIds(input.getProductosIds());
        if (productos.isEmpty()) {
            throw new PedidoInvalidoException("No hay productos disponibles.");
        }

        // 2. Crear el pedido
        Pedido pedido = new Pedido(input.getClienteId(), productos);

        // 3. Procesar el pago
        boolean pagoExitoso = pagoService.procesarPago(input.getMetodoPago(), pedido.getTotal());
        if (!pagoExitoso) {
            throw new PedidoInvalidoException("El pago no se pudo procesar.");
        }

        // 4. Confirmar y guardar el pedido
        pedido.confirmar();
        pedidoRepository.guardarPedido(pedido);

        // 5. Devolver el resultado
        return new PedidoOutput(pedido.getId(), pedido.getEstado(), pedido.getTotal());
    }
}
