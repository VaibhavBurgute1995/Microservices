package com.microservices.user.UserService.service;

import com.microservices.user.UserService.entities.User;
import com.microservices.user.UserService.repo.UserRepository;

import java.util.List;

public interface UserService {

    public User save(User user);

    public User findById(String username);

    public List<User> findAll();
}
