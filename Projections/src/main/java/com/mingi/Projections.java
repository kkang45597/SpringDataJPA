package com.mingi;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mingi.entity.Person;
import com.mingi.repository.PersonRepository;


@SpringBootApplication
public class Projections {

	public static void main(String[] args) {
		SpringApplication.run(Projections.class, args);
	}
	
	@Bean
    CommandLineRunner init(PersonRepository personRepository) {
    	return args -> {
    		Person perosn1 = new Person("John", "Doe", null);
    		personRepository.save(perosn1);
    		Person saved1 = personRepository.findById(perosn1.getId())
    		                       .orElseThrow(NoSuchElementException::new);
    		
    		Person perosn2 = new Person("Jane", "Doe", null);
    		personRepository.save(perosn2);
    		Person saved2 = personRepository.findById(perosn2.getId())
    		                       .orElseThrow(NoSuchElementException::new);
    		
    		Person perosn3 = new Person("Baby", "Doe", null);
    		personRepository.save(perosn3);
    		Person saved3 = personRepository.findById(perosn3.getId())
    		                       .orElseThrow(NoSuchElementException::new);
    			
    	};
	}
}
