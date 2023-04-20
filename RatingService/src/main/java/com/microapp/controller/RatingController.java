package com.microapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microapp.entities.Rating;
import com.microapp.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService rService;
	
	
	//create rating
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(rService.create(rating));
	}
	
	//get all;
	@GetMapping
	public ResponseEntity<List<Rating>> getRating(){
		return ResponseEntity.ok(rService.getRatings());
		
	}
	
	//get userid;
	   @GetMapping("/users/{userId}")
		public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
			return ResponseEntity.ok(rService.getRatingByUserId(userId));
			
		}
		//get hotelid;
		@GetMapping("/hotels/{hotelId}")
		public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
			return ResponseEntity.ok(rService.getRatingByHotelId(hotelId));
			
		}
	
	
}
