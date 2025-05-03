package com.example.canteen_management.controller;


import org.springframework.web.bind.annotation.RestController;

import com.example.canteen_management.model.User;
import com.example.canteen_management.service.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
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

}
