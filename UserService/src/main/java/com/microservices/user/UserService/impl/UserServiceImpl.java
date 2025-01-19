package com.microservices.user.UserService.impl;

import com.microservices.user.UserService.client.FeignClientConfigHotel;
import com.microservices.user.UserService.client.FeignClientConfigrating;
import com.microservices.user.UserService.controllers.UserServiceController;
import com.microservices.user.UserService.entities.Hotels;
import com.microservices.user.UserService.entities.Ratings;
import com.microservices.user.UserService.entities.User;
import com.microservices.user.UserService.repo.UserRepository;
import com.microservices.user.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    FeignClientConfigHotel feignClientConfig;

    @Autowired
    FeignClientConfigrating feignClientConfigrating;

    @Autowired
    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(UserServiceController.class);


    @Override
    public User save(User user) {
        String uniqId = UUID.randomUUID().toString();
        user.setUserId(uniqId);
        return userRepository.save(user);
    }
    @Override
    public User findById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        Ratings[] ratingArray = feignClientConfigrating.getRatingsByUser(user.getUserId());
        //restTemplate.getForObject("http://HOTELRATING/ratings/user/" + user.getUserId(), Ratings[].class);
        logger.info(ratingArray[0].toString());
        List<Ratings> ratings = Arrays.stream(ratingArray).toList();
        logger.info("Ratings List: {}", ratings);

        for (Ratings rating : ratings) {
            Hotels hotel = feignClientConfig.getRatingsByHotelId(rating.getHotelId());
            //restTemplate.getForObject("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotels.class);
            List<Hotels> hotelsList = new ArrayList<>();
            if (hotel != null) {
                hotelsList.add(hotel);  // Add the single hotel to the list
            }
            rating.setHotels(hotelsList);  // Set the hotel list in the rating
        }
        logger.info("Found " + ratings.size() + " ratings for user.");
        user.setRatings(ratings);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = userRepository.findAll();
        for (User user : allUsers) {
            List<Ratings> ratingArray = feignClientConfigrating.getAllRatingsByUser(user.getUserId());
            List<Ratings> allRatings = new ArrayList<>();
            allRatings.addAll(ratingArray);
            user.setRatings(allRatings);
            for (Ratings rating : ratingArray) {
                Hotels allHotelsById = feignClientConfig.getAllRatingsByHotelId(rating.getHotelId());
                List<Hotels> allHotels = new ArrayList<>();
                allHotels.add(allHotelsById);
                rating.setHotels(allHotels);
            }
        }
        return allUsers;
    }
}
