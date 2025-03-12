package com.microservice.RatingService.Service;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.RatingService.ExternalService.HotelServiceExtInt;
import com.microservice.RatingService.Repository.RatingRepository;
import com.microservice.RatingService.entity.Hotel;
import com.microservice.RatingService.entity.Rating;

@Service
public class RatingService implements RatingServiceInterface {

	@Autowired
	HotelServiceExtInt hotelclient;
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	RatingRepository ratingRepo;

	@Override
	public Rating create(Rating rating) {

		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String UserId) {

		List<Rating> rating = ratingRepo.findByUserId(UserId).stream().map(r -> {
			
			//ResponseEntity<Hotel> forHotel = restTemplate.getForEntity("http://HOTELSERVICE/hotel/" + r.getHotelId(),
			//		Hotel.class);
			//Hotel hotel=forHotel.getBody();
			
			Hotel hotel = hotelclient.getHotel(r.getHotelId());
			r.setHotel(hotel);
			return r;
		}).collect(Collectors.toList());

		return rating;
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByHotelId(hotelId);
	}

}
