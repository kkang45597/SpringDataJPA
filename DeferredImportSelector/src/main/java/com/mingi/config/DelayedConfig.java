package com.mingi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class DelayedConfig {

	@Bean
	public String delayedService() {
		 return "Delayed Service Bean Loaded";
	}
}
