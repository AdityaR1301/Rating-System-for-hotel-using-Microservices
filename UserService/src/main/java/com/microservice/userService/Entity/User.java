package com.microservice.userService.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
	private String userId;
	private String userName;
	private String userEmail;
	
	
}
