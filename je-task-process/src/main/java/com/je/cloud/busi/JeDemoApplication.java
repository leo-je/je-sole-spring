package com.je.cloud.busi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeDemoApplication.class, args);
	}

}
