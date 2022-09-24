package com.user;

import java.util.Date;
import java.time.Instant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
		System.out.printf("%s: Application has Started on Port 8081\n", Date.from(Instant.now()));
	}
}
