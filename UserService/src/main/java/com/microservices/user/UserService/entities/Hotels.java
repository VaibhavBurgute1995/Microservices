package com.microservices.user.UserService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Hotels {

    private String hotelId;
    private String hotelName;
    private String address;
    private String remarks;

    public Hotels(String hotelId, String hotelName, String address, String remarks) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.address = address;
        this.remarks = remarks;
    }

    public Hotels() {
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
