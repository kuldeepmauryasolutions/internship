package com.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Micro1QuizServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Micro1QuizServiceApplication.class, args);
	}

}
