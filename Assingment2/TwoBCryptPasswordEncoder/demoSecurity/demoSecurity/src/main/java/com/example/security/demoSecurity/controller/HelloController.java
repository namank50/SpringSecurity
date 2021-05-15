package com.example.security.demoSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String home() {
		return ("Hello");
	}
	
	@GetMapping("/user")
	public String home1() {
		return ("Hello User");
	}
	
	@GetMapping("/admin")
	public String home2() {
		return ("Hello Admin");
	}
	
}
