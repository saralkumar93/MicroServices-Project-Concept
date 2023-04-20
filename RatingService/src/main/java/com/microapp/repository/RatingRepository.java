package com.microapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microapp.entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{


	//custom finder methods
	public List<Rating> findByUserId(String userId);
	
	public List<Rating> findByHotelId(String hotelId);
	
}
