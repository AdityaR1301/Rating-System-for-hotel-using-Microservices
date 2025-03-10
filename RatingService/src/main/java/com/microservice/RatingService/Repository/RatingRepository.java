package com.microservice.RatingService.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.RatingService.entity.Rating;

public interface RatingRepository extends MongoRepository<Rating,String> {

	
	//cutomer finder methods
	List<Rating> findByUserId(String userId);
	List<Rating> findByHotelId(String hotelId);
	
	
	
	
}
