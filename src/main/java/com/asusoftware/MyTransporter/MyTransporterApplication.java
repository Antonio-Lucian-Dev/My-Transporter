package com.asusoftware.MyTransporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class MyTransporterApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(MyTransporterApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins(
						"http://localhost:8100"
				)
				.allowedMethods(
						"GET",
						"PUT",
						"POST",
						"DELETE",
						"PATCH",
						"OPTIONS"
				);
	}

}
