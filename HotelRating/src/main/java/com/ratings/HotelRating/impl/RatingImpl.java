package com.ratings.HotelRating.impl;

import com.ratings.HotelRating.entities.Ratings;
import com.ratings.HotelRating.repositories.RatingRepositories;
import com.ratings.HotelRating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RatingImpl implements RatingService {

    @Autowired
    private RatingRepositories ratingRepositories;

    @Override
    public Ratings saveRatings(Ratings ratings) {
        return ratingRepositories.save(ratings);
    }

    public List<Ratings> getAllRatings() {
        return ratingRepositories.findAll();
    }

    @Override
    public List<Ratings> findRatingByHotelID(String hotelId) {
        return ratingRepositories.getRatingsByHotelId(hotelId);
    }

    @Override
    public List<Ratings> findRatingByUserID(String userId) {
        return ratingRepositories.getRatingsByUserId(userId);
    }
}
