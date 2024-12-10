package com.devsuperior.bee2990;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.bee2990.dto.EmpregadoDeptDTO;
import com.devsuperior.bee2990.projections.EmpregadoDeptProjection;
import com.devsuperior.bee2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//SQL
		List<EmpregadoDeptProjection> list = repository.search1();
		List<EmpregadoDeptDTO> result1 = list.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());

		System.out.println("---SQL query---");
		for(EmpregadoDeptDTO obj : result1) {
			System.out.println(obj);
		}

		//JPQL
		List<EmpregadoDeptDTO> list2 = repository.search2();

		System.out.println("---SQL query---");
		for(EmpregadoDeptDTO obj : list2) {
			System.out.println(obj);
		}
		
	}
}
