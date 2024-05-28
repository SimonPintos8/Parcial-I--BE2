package com.example.keycloakadmin.controller;


import com.example.keycloakadmin.model.User;
import com.example.keycloakadmin.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/username/{userName}")
    public ResponseEntity<List<User>> findByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(service.findByUserName(userName));
    }




}
