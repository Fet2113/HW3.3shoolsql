package ru.hogwarts.schooll;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class SchoollApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoollApplication.class, args);
	}
}
