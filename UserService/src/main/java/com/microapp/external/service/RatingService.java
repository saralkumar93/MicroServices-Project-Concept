package com.microapp.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.microapp.entities.Rating;

import lombok.Delegate;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	//get
	
	//post
	@PostMapping("/ratings")
	public Rating createRating();

	// put
	@PutMapping("/ratings/{ratingId}")
	public Rating updateRating(@PathVariable String ratingId,Rating rating);

    //delete4
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingid);





}
