package com.example.M151LB2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)

public class M151Lb2Application {

	public static void main(String[] args) {
		SpringApplication.run(M151Lb2Application.class, args);
	}

}
