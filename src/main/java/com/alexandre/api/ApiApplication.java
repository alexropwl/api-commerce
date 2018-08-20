package com.alexandre.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.api.domain.Categoria;
import com.alexandre.api.repositories.CategoriaRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository catRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		catRepository.saveAll(Arrays.asList(cat1, cat2));

	}

}
