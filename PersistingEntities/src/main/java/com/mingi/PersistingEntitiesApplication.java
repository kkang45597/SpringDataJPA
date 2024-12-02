package com.mingi;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mingi.entity.User;
import com.mingi.repository.UserRepository;

@SpringBootApplication
public class PersistingEntitiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistingEntitiesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository repository) {
		return args -> {
			User user = new User();
			user.setName("John");
			user.setLastname("Doe");
			user.setEmail("JohnDoe@example.com");
			repository.save(user);
			User saved = repository.
					findById(user.getId()).
					orElseThrow(NoSuchElementException::new);
			
			User user2 = new User();
			user2.setName("Jane");
			user2.setLastname("Doe");
			user2.setEmail("JaneDoe@example.com");
			repository.save(user2);
			User saved2 = repository.
					findById(user2.getId()).
					orElseThrow(NoSuchElementException::new);
			
			User user3 = new User();
			user3.setName("Baby");
			user3.setLastname("Doe");
			user3.setEmail("BabyDoe@example.com");
			repository.save(user3);
			User saved3 = repository.
					findById(user3.getId()).
					orElseThrow(NoSuchElementException::new);
			
		};
	}

}
