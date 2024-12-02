package com.mingi;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mingi.entity.Person;
import com.mingi.repository.PersonRepository;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(PersonRepository repository) {
    return args -> {
      Person person = new Person();
      person.setName("John");

      repository.save(person);
      Person saved = repository.
    		  findById(person.getId()).
    		  orElseThrow(NoSuchElementException::new);
    };
  }
}