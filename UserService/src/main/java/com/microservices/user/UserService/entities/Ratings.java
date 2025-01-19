package com.microservices.user.UserService.entities;

import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

public class Ratings {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int ratinga;
    private String remarks;
    @Transient
    private List<Hotels> hotels = new ArrayList();
    public Ratings() {
    }

    public Ratings(String ratingId, String userId, String hotelId, int ratinga, String remarks,List<Hotels> hotels) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.ratinga = ratinga;
        this.remarks = remarks;
        this.hotels = hotels;
    }
    public List<Hotels> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotels> hotels) {
        this.hotels = hotels;
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

    public int getRatinga() {
        return ratinga;
    }

    public void setRatinga(int ratinga) {
        this.ratinga = ratinga;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "ratingId='" + ratingId + '\'' +
                ", userId='" + userId + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", ratinga=" + ratinga +
                ", remarks='" + remarks + '\'' +
                ", hotels=" + hotels +
                '}';
    }
}
