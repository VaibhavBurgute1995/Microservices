package com.ratings.HotelRating.services;

import com.ratings.HotelRating.entities.Ratings;

import java.util.List;

public interface RatingService {

    public Ratings saveRatings(Ratings ratings);

    public List<Ratings> getAllRatings();

    public List<Ratings> findRatingByHotelID(String hotelId);

    public List<Ratings> findRatingByUserID(String userId);
}
