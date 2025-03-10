package com.microservice.userService.Entity;

public class Rating {

	private String ratingId;
	private String userId;
	private String hotelId;
	private String hoteId;
	private int rating;
	private String feedback;
	
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
	public String getHoteId() {
		return hoteId;
	}
	public void setHoteId(String hoteId) {
		this.hoteId = hoteId;
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
		this.hoteId = hoteId;
		this.rating = rating;
		this.feedback = feedback;
	}
	
	public Rating() {
		super();
	}
	
	
	
	
}
