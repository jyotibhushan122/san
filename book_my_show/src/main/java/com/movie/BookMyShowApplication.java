package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "org.movie.*")
@EnableJpaRepositories(basePackages = "org.movie.*")
@EntityScan(basePackages = "org.movie.*")
public class BookMyShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

}
