package com.microservice.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.HotelService.Entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
