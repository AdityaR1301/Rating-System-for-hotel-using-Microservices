package com.microservice.RatingService.ExternalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.RatingService.entity.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface HotelServiceExtInt {

	@GetMapping("/hotels/{hotelid}")
	Hotel getHotel(@PathVariable String hotelid);
}
