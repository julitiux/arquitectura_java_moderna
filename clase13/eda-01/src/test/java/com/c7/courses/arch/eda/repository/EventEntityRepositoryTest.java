package com.c7.courses.arch.eda.repository;

import com.c7.courses.arch.eda.pedido.command.CrearPedidoCommand;
import com.c7.courses.arch.eda.pedido.domain.repository.EventStore;
import com.c7.courses.arch.eda.pedido.domain.service.PedidoCommandService;
import com.c7.courses.arch.eda.pedido.infraestructura.salida.repository.JpaEntityEventRepository;
import com.c7.courses.arch.eda.pedido.infraestructura.salida.repository.entity.JpaEntityEvent;
import com.c7.courses.arch.eda.pedido.infraestructura.spring.PedidoBeanFactory;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.test.context.SpringRabbitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Import(PedidoBeanFactory.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Testcontainers
@SpringRabbitTest
public class EventEntityRepositoryTest {

    @Autowired
    private JpaEntityEventRepository eventRepository;
    @Autowired
    private EventStore eventStore;
    @Autowired
    private PedidoCommandService pedidoCommandService;

    @Test
    void shouldTestTheMainComponents() {

        String pedidoId = "entityId";
        String entityName = "pedido";
        String clientId = "clienteId";

        final var crearPedidoCommand = new CrearPedidoCommand(pedidoId, clientId);
        pedidoCommandService.crearPedido(crearPedidoCommand);

        var eventos = eventRepository.findAllByEntityNameAndEntityIdOrderByCreatedAt(entityName, pedidoId);

        assertThat(eventos.size())
            .isEqualTo(1);

        var pedido = pedidoCommandService.reconstruirPedidoDesdeEventos(eventStore, pedidoId);

        assertThat(pedido.getPedidoId())
            .isEqualTo(pedidoId);
        assertThat(pedido.getClienteId())
            .isEqualTo(clientId);
        assertThat(pedido.getEventos().size())
            .isEqualTo(1);
        assertThat(pedido.isEsConfirmado())
            .isFalse();

        pedidoCommandService.confirmarPedido(pedidoId);

        var pedidoEventos = this.eventRepository.findAllByEntityNameAndEntityIdOrderByCreatedAt(entityName, pedidoId);
        assertThat(pedidoEventos.size())
            .isEqualTo(2);

        var pedidoConfirmado = pedidoCommandService.reconstruirPedidoDesdeEventos(eventStore, pedidoId);

        assertThat(pedidoConfirmado)
            .isNotNull();
        assertThat(pedidoConfirmado.getEventos().size())
            .isEqualTo(2);
        assertThat(pedidoConfirmado.isEsConfirmado())
            .isTrue();

    }
}
