package com.succeedinacademia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SucceedinacademiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SucceedinacademiaApplication.class, args);
	}

}
