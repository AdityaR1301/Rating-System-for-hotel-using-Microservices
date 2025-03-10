package com.microservice.HotelService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.HotelService.Entity.Hotel;
import com.microservice.HotelService.Exception.ResourceNotFound;
import com.microservice.HotelService.Repository.HotelRepository;

@Service
public class HotelService implements HotelServiceInterface{

	@Autowired
	HotelRepository hotelRepo;
	
	@Override
	public Hotel create(Hotel hotel) {
		
		hotel.setId(UUID.randomUUID().toString());
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getall() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		return (hotelRepo.findById(id)).orElseThrow(()-> new ResourceNotFound("Id not found in server- "+id) );
	}

}
