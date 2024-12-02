package com.mingi;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mingi.entity.Product;
import com.mingi.repository.ProductRepository;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	
	@Bean
	CommandLineRunner runner(ProductRepository repository) {
		return args -> {
	    	
			Product saved1 = repository.save(new Product("과자 A", BigDecimal.valueOf(1000)));
			Product saved2 = repository.save(new Product("과자 B", BigDecimal.valueOf(2000)));
			Product saved3 = repository.save(new Product("과자 C", BigDecimal.valueOf(1500)));
	    };
	  }
}
