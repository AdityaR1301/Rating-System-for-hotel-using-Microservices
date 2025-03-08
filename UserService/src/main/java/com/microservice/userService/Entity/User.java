package com.microservice.userService.Entity;

import jakarta.persistence.*;



@Entity
@Table(name="User")
public class User {

	@Id
	//@Column(name="userid")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	//@Column(name="username")
	private String userName;
	//@Column(name="useremail")
	private String userEmail;
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + "]";
	}

	
	public User(int userId, String userName, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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
