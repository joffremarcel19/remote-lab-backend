package com.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class LaboratoryBackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LaboratoryBackendApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LaboratoryBackendApplication.class);
	}

}
