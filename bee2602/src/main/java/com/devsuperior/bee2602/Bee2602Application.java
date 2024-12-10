package com.devsuperior.bee2602;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.bee2602.dto.CustomerMinDTO;
import com.devsuperior.bee2602.projections.CustomerMinProjection;
import com.devsuperior.bee2602.repositories.CustomerRepository;

@SpringBootApplication
public class Bee2602Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Bee2602Application.class, args);
	}

	@Override
	public void run(String... args) {

		//SQL
		System.out.println("\n---SQL Query---");
		List<CustomerMinProjection> list = repository.search1("rs");
		List<CustomerMinDTO> result1 = list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());

		for(CustomerMinDTO obj : result1) {
			System.out.println(obj);
		}

		//JPQL
		System.out.println("\n---JPQL Query---");
		List<CustomerMinDTO> result2 = repository.search2("rs");

		for(CustomerMinDTO obj : result2) {
			System.out.println(obj);
		}
		
	}
}
