package com.c7.curso.arch.hexagonal.configuracion;

import com.c7.curso.arch.hexagonal.aplicacion.servicio.PedidoServiceImpl;
import com.c7.curso.arch.hexagonal.dominio.gateway.NotificationService;
import com.c7.curso.arch.hexagonal.dominio.gateway.PaymentGateway;
import com.c7.curso.arch.hexagonal.dominio.repositorio.ItemRepository;
import com.c7.curso.arch.hexagonal.dominio.repositorio.PedidoRepository;
import com.c7.curso.arch.hexagonal.dominio.servicio.PedidoService;
import com.c7.curso.arch.hexagonal.infraestructura.salida.servicioexterno.NotificationServiceImpl;
import com.c7.curso.arch.hexagonal.infraestructura.salida.servicioexterno.PaymentGatewayStripe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {
    @Bean
    public PedidoService pedidoService(
        PedidoRepository pedidoRepository,
        ItemRepository itemRepository,
        PaymentGateway paymentGateway,
        NotificationService notificationService
    ) {
        return new PedidoServiceImpl(pedidoRepository, itemRepository, paymentGateway, notificationService);
    }

    @Bean
    public NotificationService notificationService() {
        return new NotificationServiceImpl();
    }

    @Bean
    public PaymentGateway paymentGateway() {
        return new PaymentGatewayStripe();
    }
}
