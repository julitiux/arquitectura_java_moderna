package com.c7.course.arch.clean.pedidos.infrastructure.configuration;

import com.c7.course.arch.clean.pedidos.application.interactors.CancelarPedidoInteractor;
import com.c7.course.arch.clean.pedidos.application.interactors.RealizarPedidoInteractor;
import com.c7.course.arch.clean.pedidos.application.services.PagoService;
import com.c7.course.arch.clean.pedidos.application.usecases.CancelarPedidoUseCase;
import com.c7.course.arch.clean.pedidos.application.usecases.RealizarPedidoUseCase;
import com.c7.course.arch.clean.pedidos.domain.repository.PedidoRepository;
import com.c7.course.arch.clean.pedidos.domain.repository.ProductoRepository;
import com.c7.course.arch.clean.pedidos.infrastructure.repositories.JpaPedidoRepository;
import com.c7.course.arch.clean.pedidos.infrastructure.repositories.JpaProductoRepository;
import com.c7.course.arch.clean.pedidos.infrastructure.repositories.SpringDataPedidoRepository;
import com.c7.course.arch.clean.pedidos.infrastructure.repositories.SpringDataProductoRepository;
import com.c7.course.arch.clean.pedidos.infrastructure.services.StripePagoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanFactory {

    @Bean
    public PedidoRepository pedidoRepository(JpaPedidoRepository jpaPedidoRepository) {
        return new SpringDataPedidoRepository(jpaPedidoRepository);
    }

    @Bean
    public ProductoRepository productoRepository(JpaProductoRepository jpaProductoRepository) {
        return new SpringDataProductoRepository(jpaProductoRepository);
    }

    @Bean
    public PagoService stripePagoService() {
        return new StripePagoService();
    }

    @Bean
    public RealizarPedidoUseCase realizarPedidoInteractor(PedidoRepository pedidoRepository,
                                                          ProductoRepository productoRepository,
                                                          PagoService pagoService) {
        return new RealizarPedidoInteractor(pedidoRepository, productoRepository, pagoService);
    }

    @Bean
    public CancelarPedidoUseCase cancelarPedidoInteractor(PedidoRepository pedidoRepository) {
        return new CancelarPedidoInteractor(pedidoRepository);
    }
}
