package com.example.canteen_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.canteen_management.model.Fooddetails;
import com.example.canteen_management.repo.Foodrepo;

import jakarta.transaction.Transactional;

@Service
public class Foodservice {
    @Autowired
    private Foodrepo foodrepo;

    public List<Fooddetails> getAllFood() {
        return foodrepo.findAll();
    }

    public Fooddetails addFood(Fooddetails food) {
        return foodrepo.save(food);
    }

    @Transactional
    public void update(String food_name, int price, boolean isAvailable) {
        foodrepo.updateByFoodName(food_name, price, isAvailable);
    }
    
    @Transactional
    public void deleteFood(String food_name) {
        foodrepo.deleteByname(food_name);
    }


}
