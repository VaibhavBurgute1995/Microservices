package com.microservices.user.UserService.client;

import com.microservices.user.UserService.entities.Hotels;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface FeignClientConfigHotel {

    @GetMapping("/hotels/{hotelId}")
    Hotels getRatingsByHotelId(@PathVariable String hotelId);

    @GetMapping("/hotels/{hotelId}")
    Hotels getAllRatingsByHotelId(@PathVariable String hotelId);

}
