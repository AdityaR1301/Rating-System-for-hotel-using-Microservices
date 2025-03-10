package com.microservice.HotelService.services;

import java.util.List;

import com.microservice.HotelService.Entity.Hotel;

public interface HotelServiceInterface {

	//create
	Hotel create(Hotel hotel);
	
	//getall
	List<Hotel> getall();
	
	//gethotel
	Hotel getHotel(String id);
	
	
}
