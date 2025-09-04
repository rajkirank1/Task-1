package com.worknest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WorknestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorknestappApplication.class, args);
	}

}
