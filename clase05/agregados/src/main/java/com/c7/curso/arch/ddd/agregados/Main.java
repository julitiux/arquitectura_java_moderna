package com.c7.curso.arch.ddd.agregados;

import com.c7.curso.arch.ddd.agregados.domain.Customer;
import com.c7.curso.arch.ddd.agregados.domain.Order;
import com.c7.curso.arch.ddd.agregados.domain.Product;

public class Main {
    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();
        // Crear cliente
        Customer customer = new Customer("CUST123", "Domingo");

        // Crear pedido (aggregate root)
        Order order = new Order(customer);

        // Crear productos
        Product book1 = new Product("BOOK1", "Java DDD", 30.0);
        Product book2 = new Product("BOOK2", "Clean Architecture", 25.0);

        // Agregar artículos al pedido
        order.addItem(book1, 2);
        order.addItem(book2, 1);

        // Confirmar pedido
        order.confirmOrder();

        //Guardar el pedido
        orderRepository.save(order);

        // Mostrar detalles del pedido
        System.out.println("Pedido confirmado para: " + order.getCustomer().getName());
        order.getItems().forEach(item -> {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName());
        });

        // Leer el pedido usando el repositorio
        Order orderFromRepository = orderRepository.findById(order.getOrderId());

        //
        orderFromRepository.cancelOrder();

        //Guardar el pedido
        orderRepository.save(orderFromRepository);
    }
}

