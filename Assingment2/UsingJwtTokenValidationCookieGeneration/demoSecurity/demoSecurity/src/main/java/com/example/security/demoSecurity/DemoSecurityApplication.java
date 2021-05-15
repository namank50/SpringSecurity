package com.example.security.demoSecurity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.security.demoSecurity.entity.User;
import com.example.security.demoSecurity.repository.REpo;

@SpringBootApplication
public class DemoSecurityApplication {
	@Autowired
	private REpo userRepo;
	
	@PostConstruct
	private void initUser() {
		List<User> users=Stream.of(new User(123,"naman","nkss","nk@gmail.com"),
				new User(123,"raj","nkisss","nkad@gmail.com"),
				new User(123,"namanKapoor","nkisss","nkad@gmail.com")
				).collect(Collectors.toList());;
		userRepo.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
	}

}
