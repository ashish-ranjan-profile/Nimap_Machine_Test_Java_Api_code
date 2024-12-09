package com.Nimap_api_test.Nimap_api_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nimap_api_test.Nimap_api_test.entities.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

	
}
