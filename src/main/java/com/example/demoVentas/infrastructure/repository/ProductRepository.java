package com.example.demoVentas.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demoVentas.infrastructure.entity.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{
	
	//Optional<Product> findById_product();
}
