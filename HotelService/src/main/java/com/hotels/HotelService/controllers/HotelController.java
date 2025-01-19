package com.hotels.HotelService.controllers;

import com.hotels.HotelService.entities.Hotels;
import com.hotels.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotels> save (@RequestBody Hotels hotels){
       Hotels savedHotels =  hotelService.save(hotels);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotels);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotels> getHotelById(@PathVariable String hotelId){
        Hotels hotelss = hotelService.findById(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(hotelss);
    }

    @GetMapping
    public List<Hotels> getAllHotels(){
        List<Hotels> allHotels = hotelService.findaALl();
        return allHotels;
    }
}
