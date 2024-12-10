package com.devsuperior.bee2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.bee2609.dto.CategorySumDTO;
import com.devsuperior.bee2609.projections.CategorySumProjection;
import com.devsuperior.bee2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//SQL
		System.out.println("\n---SQL Query---");
		List<CategorySumProjection> list = repository.search1();
		List<CategorySumDTO> result1 = list.stream().map(x -> new CategorySumDTO(x)).collect(Collectors.toList());

		for(CategorySumDTO obj : result1) {
			System.out.println(obj);
		}

		//JPQL
		System.out.println("\n---JPQL Query---");
		List<CategorySumDTO> result2 = repository.search2();

		for(CategorySumDTO obj : result2) {
			System.out.println(obj);
		}

	}
}
