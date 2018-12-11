package com.qa.ali.sonia.springboot.database.hello.GarageSpringBootDatabaseApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GarageSpringBootDatabaseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarageSpringBootDatabaseAppApplication.class, args);
	}
}
