package com.microapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microapp.entities.Hotel;
import com.microapp.entities.Rating;
import com.microapp.entities.User;
import com.microapp.exceptions.ResourceNotFoundException;
import com.microapp.external.service.HotelService;
import com.microapp.repository.UserRepository;



@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplte;

	@Autowired
	private HotelService hotelService;
	
	private Logger logger=(Logger) LoggerFactory.getLogger(UserService.class);
	
	
	
	@Override
	public User saveUser(User user) {
		//generate unique user id
		//String randomUserId = UUID.randomUUID().toString();
		//user.setUserId(randomUserId);
		return userRepository.save(user);
	}
    @Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
    @Override
	public User getUser(String userId) {
		
    	
    	//get single database  
    	User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server :"+userId));
	   
    	//fetch rating of the above user from RATING SERVICE
    	//http://localhost:8083/users/4028abfb877f3f8f01877f3fcf6e0000  	
    	
    	
    	Rating[] ratingOfUser = restTemplte.getForObject("http://RATING-SERVICE/rating/user/"+user.getUserId(),Rating[].class);
    	logger.info("{}",ratingOfUser);
    	
    	List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
    	
    	
    	//user.setRatings(ratingOfUser);
    
    	List<Rating> ratingList= ratings.stream().map(rating->{
    		//api to hotelservice to get the hotel
    		//http://localhost:8082/hotels/......
    		
    		//ResponseEntity<Hotel> forEntity= restTemplte.getForEntity("//http://HOTEL-SERVICE/hotels/"+rating.getHotel(),Hotel.class);
    		
    		//Hotel hotel= forEntity.getBody();
    		 Hotel hotel=hotelService.getHotel(rating.getHotelId());
    		//logger.info("response status code: {}", forEntity.getStatusCode());
    		
    		//set the hotel to rating 
    		rating.setHotel(hotel);   		
    		// return the rating 
    		return rating;
    		
    	}).collect(Collectors.toList());
    	
    	user.setRatings(ratingList);
    	return user;
	   
    }

}
