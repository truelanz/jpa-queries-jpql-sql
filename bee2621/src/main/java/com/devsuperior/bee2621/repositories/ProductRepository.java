package com.devsuperior.bee2621.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.bee2621.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
