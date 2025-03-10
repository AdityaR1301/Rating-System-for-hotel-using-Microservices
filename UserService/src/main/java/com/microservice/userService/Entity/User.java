package com.microservice.userService.Entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	private String userName;
	private String userEmail;

	@Transient
	private List<Rating> ratings;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + "]";
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public User(String userId, String userName, String userEmail, List<Rating> ratings) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.ratings = ratings;
	}

	public User() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
