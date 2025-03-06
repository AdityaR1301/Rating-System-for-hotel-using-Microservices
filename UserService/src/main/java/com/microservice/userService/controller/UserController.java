package com.microservice.userService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.microservice.userService.Entity.User;
import com.microservice.userService.Service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getall(){
		return ResponseEntity.ok(userService.getAll());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<User>> getuser(@RequestBody String id){
		return ResponseEntity.ok(userService.getuser(id));
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return ResponseEntity.ok(userService.saveUser(user));
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User user){
		return ResponseEntity.ok(userService.updateUser(user));
	}
}
