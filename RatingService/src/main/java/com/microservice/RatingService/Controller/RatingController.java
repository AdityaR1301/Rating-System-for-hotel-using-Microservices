package com.microservice.RatingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.RatingService.Service.RatingService;
import com.microservice.RatingService.entity.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService service;
	@PostMapping("/save")
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getall(){
		return ResponseEntity.status(HttpStatus.FOUND).body(service.getRatings());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getbyUserId(@PathVariable String userId){
		return ResponseEntity.ok(service.getRatingByUserId(userId));
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getbyHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(service.getRatingByHotelId(hotelId));
	}
	
}
