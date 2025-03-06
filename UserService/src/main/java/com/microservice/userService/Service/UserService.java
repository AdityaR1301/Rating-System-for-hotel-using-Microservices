package com.microservice.userService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.userService.Entity.User;
import com.microservice.userService.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	
	public List<User> getAll() {
		return repository.findAll();
		
	}
	
	public Optional<User> getuser(String id){
		return repository.findById(id);
	}
	
	public User saveUser(User user){
		return repository.save(user);
	}
	
	public User updateUser(User user){
		return repository.save(user);
	}
	

}
