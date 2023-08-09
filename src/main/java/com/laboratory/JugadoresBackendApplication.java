package com.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class JugadoresBackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(JugadoresBackendApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JugadoresBackendApplication.class);
	}

}
