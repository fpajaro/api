package com.projects.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.api.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
