package com.mingi.service;

import org.springframework.stereotype.Service;

import com.mingi.repository.ProductRepository;
import com.mingi.wrapper.Products;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	
	public Products getProductsByDescription(String description) {
		return productRepository.findAllByDescriptionContaining(description);
	}
	
	public void printTotalPrice(String description) {
		Products Products = getProductsByDescription(description);
		System.out.println("Total Price: " + Products.getTotalPrice());
	}
}
