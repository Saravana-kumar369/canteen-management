package com.example.canteen_management.controller;


import org.springframework.web.bind.annotation.RestController;

import com.example.canteen_management.model.User;
import com.example.canteen_management.service.Userservice;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private Userservice userservice;

    // public Usercontroller(Userservice userservice) {
    //     this.userservice = userservice;
    // }

    @PostMapping("/add")
    public User  saveuser(@RequestBody User userdata) {
        return userservice.saveuser(userdata);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginData) {
        String userName = loginData.get("userName");
        String userPassword = loginData.get("userPassword");

        try {
            User user = userservice.login(userName, userPassword);
            if (user != null) {
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login error: " + e.getMessage());
        }
    }

}
