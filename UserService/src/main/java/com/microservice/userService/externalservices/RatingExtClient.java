package com.microservice.userService.externalservices;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.microservice.userService.Entity.Rating;

@FeignClient(name="RATINGSERVICE")
public interface RatingExtClient {

	@GetMapping("/ratings/user/{userid}")
	List<Rating> getRatings(@PathVariable String userid); 
	
	@PostMapping("/ratings/save")
	Rating createRating(Rating values);
	
	
	@PutMapping("/ratings/updateRating")
	Rating updateRating(Rating rating);
}
