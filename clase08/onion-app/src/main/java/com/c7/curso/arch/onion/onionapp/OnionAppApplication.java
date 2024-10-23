package com.c7.curso.arch.onion.onionapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.c7.curso.arch.onion.onionapp.domain.entity")
public class OnionAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnionAppApplication.class, args);
	}

}
