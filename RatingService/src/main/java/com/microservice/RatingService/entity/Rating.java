package com.microservice.RatingService.entity;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("rating")
public class Rating {

	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
//	@Transient
//	private List<Hotel> hotel;
//	public List<Hotel> getHotel() {
//		return hotel;
//	}
//	public void setHotel(List<Hotel> hotel) {
//		this.hotel = hotel;
//	}
	
	@Transient
	private Hotel hotel;

	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel2) {
		this.hotel = hotel2;
	}
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public Rating(String ratingId, String userId, String hotelId, String hoteId, int rating, String feedback) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedback = feedback;
	}
	
	public Rating() {
		super();
	}
	

	
}
