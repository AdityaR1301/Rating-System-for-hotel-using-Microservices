package com.microservice.userService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.userService.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
