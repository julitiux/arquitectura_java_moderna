package com.c7.course.arch.clean.pedidos.infrastructure.repositories;

import com.c7.course.arch.clean.pedidos.domain.Pedido;
import com.c7.course.arch.clean.pedidos.domain.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

public class SpringDataPedidoRepository implements PedidoRepository {
    private final JpaPedidoRepository jpaPedidoRepository;

    public SpringDataPedidoRepository(JpaPedidoRepository jpaPedidoRepository) {
        this.jpaPedidoRepository = jpaPedidoRepository;
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        // TODO: mapeo de propiedades del domain al entity de JPA
        jpaPedidoRepository.save(pedidoEntity);
        return pedido;
    }

    @Override
    public Optional<Pedido> obtenerPedidoPorId(Long id) {
        return jpaPedidoRepository.findById(id)
                .map(pedidoEntity ->
                        new Pedido(
                                pedidoEntity.getId(),
                                pedidoEntity.getClienteId(),
                                List.of() // query pendiente
                        )
                );
    }
}
