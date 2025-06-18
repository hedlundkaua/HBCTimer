package com.HBCTimerAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "HBCTimer API", version = "1.0", description = "Documentação da API do HBCTimer"))
public class HbcTimerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HbcTimerApplication.class, args);
	}

}
