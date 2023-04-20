package com.microapp.services;

import java.util.List;

import com.microapp.entities.User;

public interface UserService {
	
	//create
	User saveUser(User user);
	
	//get all user
	List<User> getAllUser();
	
	//get single user given by id
	User getUser(String userId);
	
	
	
	//delete 
	
	//update

}
