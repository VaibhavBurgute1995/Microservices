package com.microservices.user.UserService.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Micro_Users")
public class User {

    @Id
    @Column(name = "ID")
    private String userId;

    @Column(name = "NAME")
    private String userName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;

    @Transient
    private List<Ratings> ratings = new ArrayList();

    public User() {
    }

    public User(String userId, String userName, String email, String about, List<Ratings> ratings) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.about = about;
        this.ratings = ratings;
    }

    public List<Ratings> getRatings() {
        return ratings;
    }


    public User setRatings(List<Ratings> ratings) {
        this.ratings = ratings;
        return null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
