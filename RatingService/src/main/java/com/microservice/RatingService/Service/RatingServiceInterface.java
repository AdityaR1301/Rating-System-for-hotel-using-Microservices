package com.microservice.RatingService.Service;

import java.util.List;

import com.microservice.RatingService.entity.Rating;

public interface RatingServiceInterface {

	Rating create(Rating rating);
	
	List<Rating> getRatings();

	List<Rating> getRatingByUserId(String UserId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	
}
