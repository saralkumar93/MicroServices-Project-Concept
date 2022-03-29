package com.contact.service;

import java.util.List;

import com.contact.entity.Contact;


public class ContactServiceImpl implements ContactService {

	// fake list of contacts
	
	List<Contact> list=List.of(
			new Contact(1L,"Saral@gmail.com","saral",1311L),
			new Contact(2L,"amit@gmail.com","amit",1311L),
			new Contact(3L,"vipul@gmail.com","vipul",1312L),
			new Contact(4L,"karam@gmail.com","karan",1313L)
			
						
				
			);
	
	
	
	public List<Contact> getContactOfUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
