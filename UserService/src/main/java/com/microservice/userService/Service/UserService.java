package com.microservice.userService.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.userService.Entity.User;
import com.microservice.userService.Exception.ResourceAlreadyFoundException;
import com.microservice.userService.Exception.ResourceNotFoundException;
import com.microservice.userService.Repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	UserRepository repository;

	public List<User> getAll() {
		return repository.findAll();

	}

	public User getuser(String id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on server with id- " + id));
	}

	public User saveUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		Optional<User> u1 = Optional.empty();
		Optional<User> existEmail = Optional.ofNullable(repository.findByUserEmail(user.getUserEmail()));
		if (!existEmail.isPresent()) {
			u1 = Optional.of(repository.save(user));
		}

		return u1.orElseThrow(
				() -> new ResourceAlreadyFoundException("Email Aready Exixt with email- " + user.getUserEmail()));

	}

	public User updateUser(User user) {
		Optional<User> u1 = Optional.empty();
		Optional<User> existEmail = Optional.ofNullable(repository.findByUserEmail(user.getUserEmail()));
		getuser(user.getUserId());
		if (!existEmail.isPresent()) {
			u1 = Optional.of(repository.save(user));
		}

		return u1.orElseThrow(() -> new ResourceAlreadyFoundException(
				"Email Aready Exist with email- " + user.getUserEmail() + " . Give another userEmail to update"));
	}

}
