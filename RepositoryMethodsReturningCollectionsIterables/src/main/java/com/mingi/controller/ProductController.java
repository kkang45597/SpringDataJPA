package com.mingi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mingi.service.ProductService;
import com.mingi.wrapper.Products;


@RestController
public class ProductController {

	@Autowired
    private ProductService productService;
	
	@GetMapping("/products")
    public Products searchProduct(@RequestParam String description) {
        return productService.getProductsByDescription(description);
    }
	
	@GetMapping("/products/totalprice")
    public void getTotalPrice(@RequestParam String description) {
        productService.printTotalPrice(description);
    }
}
