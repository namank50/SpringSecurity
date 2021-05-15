package com.example.security.demoSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.demoSecurity.entity.AuthRequ;
import com.example.security.demoSecurity.util.UtilUserCust;

@RestController
public class HelloController {

	@Autowired
	private UtilUserCust jwt;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String home() {
		return ("Hello");
	}
	
	@PostMapping("/auth")
	public String generate(@RequestBody AuthRequ authr)	throws Exception
	{
		try {
			authenticationManager.authenticate(
					 new UsernamePasswordAuthenticationToken(authr.getUsername(), authr.getPassword())
					);
		} catch (AuthenticationException e) {
			throw new Exception("Invalid Credentials");
		}
		return jwt.generateToken(authr.getUsername());
		
	}
}
