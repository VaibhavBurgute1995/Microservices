package com.hotels.HotelService.repositories;

import com.hotels.HotelService.entities.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotels,String> {



}
