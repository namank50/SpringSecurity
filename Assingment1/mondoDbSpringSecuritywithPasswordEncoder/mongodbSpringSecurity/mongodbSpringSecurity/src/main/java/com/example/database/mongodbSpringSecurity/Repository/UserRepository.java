package com.example.database.mongodbSpringSecurity.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.database.mongodbSpringSecurity.entity.User;
import java.util.Optional;



public interface UserRepository extends MongoRepository<User,Integer> {

	Optional<User> findByusername(String username);

	
}
