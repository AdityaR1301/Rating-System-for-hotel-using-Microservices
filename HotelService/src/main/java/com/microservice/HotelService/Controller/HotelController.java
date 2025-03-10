package com.microservice.HotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.HotelService.Entity.Hotel;
import com.microservice.HotelService.services.HotelService;

@RestController
public class HotelController {

	@Autowired
	HotelService service;
	
	
	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getall(){		
		return ResponseEntity.ok(service.getall());
	}
	
	@GetMapping("/hotel/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id){
		
		return ResponseEntity.ok(service.getHotel(id));
	}
	
	@PostMapping("/savehotel")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(hotel));
	}
}
