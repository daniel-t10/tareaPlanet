package com.ejemplo_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.ejemplo.api.spring")
@EnableJpaRepositories(basePackages = "com.ejemplo.api.spring")
@EntityScan(basePackages = "com.ejemplo.api.spring")
public class ApiEjemploSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEjemploSpringApplication.class, args);
	}
	

}
