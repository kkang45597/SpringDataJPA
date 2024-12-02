package com.mingi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Helloworld {
	
	@GetMapping
	public String helloWorld() {
		return "Hello World";
	}

}
