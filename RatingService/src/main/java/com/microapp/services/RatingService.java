package com.microapp.services;

import java.util.List;

import com.microapp.entities.Rating;

public interface RatingService {

	// create 
	Rating create(Rating rating);
	
	// get all ratings
	List<Rating> getRatings();
	
	
	// get all by user id
	List<Rating> getRatingByUserId(String userId);
	
	// get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);
}
