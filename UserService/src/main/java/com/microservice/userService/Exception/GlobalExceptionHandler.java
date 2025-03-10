package com.microservice.userService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservice.userService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException e)
	{
		ApiResponse ap=new ApiResponse(e.getMessage(),false,HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(ap,HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(ResourceAlreadyFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceAlreadyFoundException(ResourceAlreadyFoundException ex){
		ApiResponse ap=new ApiResponse(ex.getMessage(),true,HttpStatus.CONFLICT);
		return new ResponseEntity<ApiResponse>(ap,HttpStatus.NOT_FOUND);
		
	}
	
}
