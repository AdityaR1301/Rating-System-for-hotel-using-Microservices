package com.microservice.userService.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.userService.Entity.Rating;
import com.microservice.userService.Entity.User;
import com.microservice.userService.Exception.ResourceAlreadyFoundException;
import com.microservice.userService.Exception.ResourceNotFoundException;
import com.microservice.userService.Repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	UserRepository repository;
	
	@Autowired
	RestTemplate restTemplate;

	
//	private Logger logger= LoggerFactory.getLogger(UserService.class);
	
	public List<User> getAll() {
				
				
				List<User> users=repository.findAll();
				return users;

	}

	public User getuser(String id) {
		User user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on server with id- " + id));

//      get ratings from rating service using url help of httpclients
		String uri="http://localhost:8083/user/"+user.getUserId();
		Rating[] ratingsofuser = restTemplate.getForObject(uri, Rating[].class);
		
		List<Rating> ratingList=Arrays.asList(ratingsofuser);
//		List<Rating> ratings1=ratingList.stream().map(rating -> {
//			System.out.println("hotel id in rating"+rating.getHotelId());
//			ResponseEntity<Hotel> forHotel=restTemplate.getForEntity("http://localhost:8082/hotel/"+rating.getHotelId(), Hotel.class);
//			Hotel hotel=forHotel.getBody();	
//			rating.setHotel(hotel);
//			return rating;
//		}).collect(Collectors.toList());
//		
		user.setRatings(ratingList);
		return user;
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
