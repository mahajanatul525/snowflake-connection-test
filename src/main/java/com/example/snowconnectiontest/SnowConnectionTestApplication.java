package com.example.snowconnectiontest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.snowconnectiontest.repository.IQueryGeneratorRepository;

@SpringBootApplication
public class SnowConnectionTestApplication implements CommandLineRunner {

	@Autowired
	private IQueryGeneratorRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SnowConnectionTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.testProce();
	}
}
