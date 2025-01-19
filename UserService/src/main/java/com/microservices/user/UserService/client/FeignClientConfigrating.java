package com.microservices.user.UserService.client;

import com.microservices.user.UserService.entities.Hotels;
import com.microservices.user.UserService.entities.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "HOTELRATING")
public interface FeignClientConfigrating {

    @GetMapping("/ratings/user/{userId}")
    Ratings[] getRatingsByUser(@PathVariable String userId);

    @GetMapping("/ratings/user/{userId}")
    List<Ratings> getAllRatingsByUser(@PathVariable String userId);
}
