package com.hotels.HotelService.services;

import com.hotels.HotelService.entities.Hotels;

import java.util.List;

public interface HotelService {

    public Hotels save(Hotels hotels);

    public Hotels findById(String id);

    public List<Hotels> findaALl();
}
