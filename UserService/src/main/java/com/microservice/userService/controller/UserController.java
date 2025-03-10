package com.microservice.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microservice.userService.Entity.User;
import com.microservice.userService.Service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getall() {
		return ResponseEntity.ok(userService.getAll());
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getuser(@PathVariable String id) {
		return ResponseEntity.ok(userService.getuser(id));
	}

	@PostMapping("/saveuser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}

	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User user) {
		return ResponseEntity.ok(userService.updateUser(user));
	}
}
