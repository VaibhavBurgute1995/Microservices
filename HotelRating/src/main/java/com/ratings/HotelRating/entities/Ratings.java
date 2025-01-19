package com.ratings.HotelRating.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ratings {

    @Id
    private String ratingId;

    private String userId;
    private String hotelId;
    private int rating;
    private String remarks;

    public Ratings() {
    }

    public Ratings(String ratingId, String userId, String hotelId, int rating, String remarks) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.remarks = remarks;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int ratinga) {
        this.rating = ratinga;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
