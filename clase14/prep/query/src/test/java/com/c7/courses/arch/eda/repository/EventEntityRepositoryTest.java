package com.c7.courses.arch.eda.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.test.context.SpringRabbitTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Testcontainers
@SpringRabbitTest
public class EventEntityRepositoryTest {


    @Test
    void shouldTestTheMainComponents() {


    }
}
