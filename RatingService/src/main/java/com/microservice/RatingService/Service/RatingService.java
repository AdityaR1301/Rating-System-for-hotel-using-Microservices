package com.microservice.RatingService.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.RatingService.Repository.RatingRepository;
import com.microservice.RatingService.entity.Hotel;
import com.microservice.RatingService.entity.Rating;

@Service
public class RatingService implements RatingServiceInterface {

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
			System.out.println("rr"+r.toString());
			ResponseEntity<Hotel> forHotel = restTemplate.getForEntity("http://localhost:8082/hotel/" + r.getHotelId(),
					Hotel.class);
			System.out.println(forHotel.toString());
			Hotel hotel = forHotel.getBody();
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
