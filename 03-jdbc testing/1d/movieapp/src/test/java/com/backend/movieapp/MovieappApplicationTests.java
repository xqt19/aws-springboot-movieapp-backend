package com.backend.movieapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieappApplicationTests {

	@Test
	void contextLoads() {
		employeeRepository.findAll();
	}

	@Autowired
	private EmployeeRepository employeeRepository;



}
