package com.example.keycloakadmin.repository;

import com.example.keycloakadmin.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    List<User> findByUserName(String userName);
    Optional<User> findById(String id);
    User deleteUserById(String id);
}
