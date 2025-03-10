package com.microservice.userService.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	
	public Optional<User> getuser(int id){
		return repository.findById(id);
	}
	
	public User saveUser(User user){
		User u1=new User();
		System.out.println(u1);
		
		Optional<User> existEmail=Optional.ofNullable(repository.findByUserEmail(user.getUserEmail())); 
		if(!existEmail.isPresent()) {
			u1=repository.save(user);
		}
		System.out.println(u1);
		return u1;
	}
	
	public User updateUser(User user){
		return repository.save(user);
	}
	

}
