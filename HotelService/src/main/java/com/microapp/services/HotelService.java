package com.microapp.services;

import java.util.List;

import com.microapp.entities.Hotel;

public interface HotelService {
	
	//create
	Hotel create(Hotel hotel);
	
	
	//get all
	List<Hotel> getAll();
	
	
	// get single
    Hotel get(String id);
}
