package com.user.service;

import java.util.List;
import java.util.*;

import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

	
	// fake userr list
	
	List<User> list=List.of(
			new User(1311l,"Saralkumar","2323231111"),
			new User(1312l,"Amit kumar","2323231111"),
			new User(1313l,"vipul ","2323231111")
			
				
			);
	
			
			
			@Override
	public User getUser(Long id) {
		
		return  list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
		
	}
	
	

}
