package com.microservice.userService.Exception;

public class ResourceAlreadyFoundException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceAlreadyFoundException() {
		super("Email id already exist");
	}
	
	public ResourceAlreadyFoundException(String msg) {
		super(msg);
	}
}

