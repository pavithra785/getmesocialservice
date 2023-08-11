package com.example.getmesocialservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class GetmesocialServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(GetmesocialServiceApplication.class, args);
	}

}

