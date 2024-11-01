package com.c7.courses.arch.eda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class EdaCommandApplicationTests {

    @Test
    void contextLoads() {
    }

}
