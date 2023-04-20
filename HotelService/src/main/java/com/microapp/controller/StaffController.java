package com.microapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@RequestMapping
	public ResponseEntity<List<String>> getStaff(){
		
		List<String> list = Arrays.asList("amit","santosh","vipul","karan");
	
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

}
