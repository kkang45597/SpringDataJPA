package com.mingi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import com.mingi.entity.Product;
import com.mingi.wrapper.Products;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Streamable<Product> findByDescriptionContaining(String description);
	
	Products findAllByDescriptionContaining(String description);
}
