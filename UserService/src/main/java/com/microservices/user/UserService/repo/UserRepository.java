package com.microservices.user.UserService.repo;

import com.microservices.user.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {


}
