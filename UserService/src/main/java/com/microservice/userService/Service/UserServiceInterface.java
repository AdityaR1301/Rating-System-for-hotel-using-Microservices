package com.microservice.userService.Service;

import java.util.List;
import com.microservice.userService.Entity.User;

public interface UserServiceInterface {

	public List<User> getAll();

	public User getuser(String id);

	public User saveUser(User user);

	public User updateUser(User user);
}
