package com.ratings.HotelRating.controllers;

import com.ratings.HotelRating.entities.Ratings;
import com.ratings.HotelRating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Ratings> saveRatings(@RequestBody Ratings ratings) {
        String id = UUID.randomUUID().toString();
        ratings.setRatingId(id);
        Ratings savedRatings = ratingService.saveRatings(ratings);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRatings);
    }

    @GetMapping
    public ResponseEntity<List<Ratings>> getAllRatings() {
        List<Ratings> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("hotel/{hotelId}")
    public ResponseEntity<List<Ratings>> getRatingByHotelId(@PathVariable String hotelId) {
        List<Ratings> ratingsByHotelId = ratingService.findRatingByHotelID(hotelId);
        return ResponseEntity.ok(ratingsByHotelId);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<Ratings>> getRatingByUserId(@PathVariable String userId) {
        List<Ratings> ratingsByUserId = ratingService.findRatingByUserID(userId);
        return ResponseEntity.ok(ratingsByUserId);
    }
}
