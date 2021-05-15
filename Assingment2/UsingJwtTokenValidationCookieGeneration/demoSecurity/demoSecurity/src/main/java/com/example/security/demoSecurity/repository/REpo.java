package com.example.security.demoSecurity.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security.demoSecurity.entity.User;

public interface REpo extends JpaRepository<User,Integer> {

	User findByUserName(String username);

}
