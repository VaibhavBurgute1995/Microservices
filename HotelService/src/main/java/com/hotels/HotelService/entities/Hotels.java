package com.hotels.HotelService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hotels {

    @Id
    @Column(name = "HOTEL_ID")
    private String hotelId;

    @Column(name = "HOTEL_NAME")
    private String hotelName;

    @Column(name = "HOTEL_ADDRESS")
    private String address;

    @Column(name = "REMARKS")
    private String remarks;

    public Hotels() {
    }

    public Hotels(String hotelId, String hotelname, String address, String remarks) {
        this.hotelId = hotelId;
        this.hotelName = hotelname;
        this.address = address;
        this.remarks = remarks;
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

    public void setHotelName(String hotelname) {
        this.hotelName = hotelname;
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
