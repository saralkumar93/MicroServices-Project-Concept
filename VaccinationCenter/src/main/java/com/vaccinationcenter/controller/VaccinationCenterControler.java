package com.vaccinationcenter.controller;

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
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vaccinationcenter.entity.VaccinationCenter;
import com.vaccinationcenter.model.Citizen;
import com.vaccinationcenter.model.RequiredResponse;
import com.vaccinationcenter.repository.CenterRepo;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterControler {
	
	@Autowired
	private CenterRepo centerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter ){
		VaccinationCenter center = centerRepo.save(vaccinationCenter);
	    return new ResponseEntity<>(center,HttpStatus.OK);
	}
	
	@GetMapping(path="/id/{id}")
	@HystrixCommand(fallbackMethod="handleCitizenDownTime")
	public ResponseEntity<RequiredResponse> getAllDetaBasedOnCenterId(@PathVariable Integer id){
		RequiredResponse requriedResponse = new RequiredResponse();
		//1st get vaccination center datails
		VaccinationCenter center = centerRepo.findById(id).get();
	    requriedResponse.setCenter(center);
	    
	    // then get all citizen register to vaccination center
	   List<Citizen> listOfCitizens= restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
	
	   requriedResponse.setCitizens(listOfCitizens);
	   return new ResponseEntity<>(requriedResponse,HttpStatus.OK);
	}
	
	public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id){
		
		RequiredResponse requiredResponse = new RequiredResponse();
		VaccinationCenter center = centerRepo.findById(id).get();
		requiredResponse.setCenter(center);
		return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
	}
	
	

}
