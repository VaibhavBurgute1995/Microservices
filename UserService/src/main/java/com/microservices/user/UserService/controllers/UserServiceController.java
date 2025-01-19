package com.microservices.user.UserService.controllers;

import com.microservices.user.UserService.entities.Ratings;
import com.microservices.user.UserService.entities.User;
import com.microservices.user.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserServiceController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(UserServiceController.class);

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User userById = userService.findById(userId);
        return ResponseEntity.ok(userById);
    }

    @GetMapping
    public ResponseEntity findAllUsers() {
        List<User> allUsers = userService.findAll();
        return ResponseEntity.ok(allUsers);

    }
}
