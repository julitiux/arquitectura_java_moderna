package com.c7.courses.arch.eda;

import org.springframework.boot.SpringApplication;

public class TestEdaApplication {

    public static void main(String[] args) {
        SpringApplication.from(EdaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
