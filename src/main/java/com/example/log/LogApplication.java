package com.example.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LogApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogApplication.class, args);
	}

        	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
                                registry.addMapping("*").allowedOrigins("https://argentinaprograma-fe026.web.app");
				//registry.addMapping("*").allowedOrigins("http://localhost:4200");
				//			registry.addMapping("/products/*").allowedOrigins("http://localhost:4200");

                        }
		};
	}

}
