package com.ratings.HotelRating.repositories;

import com.ratings.HotelRating.entities.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepositories extends JpaRepository<Ratings,String> {

    List<Ratings> getRatingsByHotelId(String hotelId);

    List<Ratings> getRatingsByUserId(String hotelId);

}
