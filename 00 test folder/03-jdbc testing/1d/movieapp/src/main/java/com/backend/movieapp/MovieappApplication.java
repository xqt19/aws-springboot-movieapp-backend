package com.backend.movieapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieappApplication {

	@Autowired
	private EmployeeRepository employeeRepository;


	public static void main(String[] args) {
		SpringApplication.run(MovieappApplication.class, args);
	}


}
