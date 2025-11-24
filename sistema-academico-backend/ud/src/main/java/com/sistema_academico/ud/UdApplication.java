package com.sistema_academico.ud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UdApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("1234"));

	}

}
