package com.hotels.HotelService.impl;

import com.hotels.HotelService.entities.Hotels;
import com.hotels.HotelService.exceptions.ResourceNotFoundException;
import com.hotels.HotelService.repositories.HotelRepository;
import com.hotels.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotels save(Hotels hotels) {
        String uniqueId = UUID.randomUUID().toString();
        hotels.setHotelId(uniqueId);
        return hotelRepository.save(hotels);
    }

    @Override
    public Hotels findById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new
                ResourceNotFoundException("Hotel not found with given Id"));
    }

    @Override
    public List<Hotels> findaALl() {
        return hotelRepository.findAll();
    }
}
