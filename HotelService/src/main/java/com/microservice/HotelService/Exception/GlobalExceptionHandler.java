package com.microservice.HotelService.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservice.HotelService.Entity.ApiEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
//	@ExceptionHandler(ResourceNotFound.class)
//	public ResponseEntity<ApiEntity> handler(ResourceNotFound ex){
//		
//		ApiEntity apiEntity=new ApiEntity(ex.getMessage(),false,HttpStatus.NOT_FOUND);
//	
//		return ResponseEntity.ok(apiEntity);	
//	}
	
	
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<Map<String,Object>> handler1(ResourceNotFound e){
		Map<String, Object> map=new HashMap<>();
		map.put("message", e.getMessage());
		map.put("Sucess", true);
		map.put("status",HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	
}
