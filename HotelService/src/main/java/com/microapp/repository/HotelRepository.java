package com.microapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.microapp.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String>{

}
