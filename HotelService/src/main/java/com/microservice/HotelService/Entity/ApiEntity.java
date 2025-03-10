package com.microservice.HotelService.Entity;

import org.springframework.http.HttpStatus;

public class ApiEntity {
	
	String message;
	Boolean sucess;
	HttpStatus status;
	public ApiEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiEntity(String message, Boolean sucess, HttpStatus status) {
		super();
		this.message = message;
		this.sucess = sucess;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSucess() {
		return sucess;
	}
	public void setSucess(Boolean sucess) {
		this.sucess = sucess;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
	
	
}
