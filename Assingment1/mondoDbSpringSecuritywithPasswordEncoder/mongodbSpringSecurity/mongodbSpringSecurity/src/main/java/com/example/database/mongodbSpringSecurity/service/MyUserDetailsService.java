package com.example.database.mongodbSpringSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.database.mongodbSpringSecurity.Repository.UserRepository;
import com.example.database.mongodbSpringSecurity.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user =userRepo.findByusername(username);
		System.out.println(user);
		user.orElseThrow(()->new UsernameNotFoundException("User Not Found" +username));
		
		return user.map(MyUserDetails::new).get();
	}

}
