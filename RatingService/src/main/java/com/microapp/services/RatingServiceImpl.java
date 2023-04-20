package com.microapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microapp.entities.Rating;
import com.microapp.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
	private RatingRepository ratingRepository;
	
    public Rating create(Rating rating) {
	    
		return ratingRepository.save(rating);
	}

	public List<Rating> getRatings() {
		
		return ratingRepository.findAll();
	}

	public List<Rating> getRatingByUserId(String userId) {
		
		return ratingRepository.findByUserId(userId);
	}

	public List<Rating> getRatingByHotelId(String hotelId) {
		
		return ratingRepository.findByHotelId(hotelId);
	}

	
}
