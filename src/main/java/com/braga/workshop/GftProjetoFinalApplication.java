package com.braga.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GftProjetoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GftProjetoFinalApplication.class, args);
	}

}
