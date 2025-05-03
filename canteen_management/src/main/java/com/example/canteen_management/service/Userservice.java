package com.example.canteen_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.canteen_management.model.User;
import com.example.canteen_management.repo.UserRepo;


@Service
public class Userservice {
    @Autowired
    private UserRepo userrepo;
    
    public User saveuser(User userdata) {
        return userrepo.save(userdata);
        
    }
}
