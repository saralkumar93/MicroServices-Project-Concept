package com.microapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microapp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	
	

}
