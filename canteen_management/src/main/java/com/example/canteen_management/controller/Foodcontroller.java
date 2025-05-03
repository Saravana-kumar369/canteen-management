package com.example.canteen_management.controller;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.canteen_management.DTO.UpdateFoodRequest;
import com.example.canteen_management.model.Fooddetails;
// Ensure this import matches the actual package and class name
import com.example.canteen_management.service.Foodservice;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/food")
public class Foodcontroller {
    
    private final Foodservice fservice;

    public Foodcontroller(Foodservice fservice) {
        this.fservice = fservice;
    }

    @PostMapping("/add")
    public Fooddetails addFood(@RequestBody Fooddetails food) {
        return fservice.addFood(food);
    }

    @GetMapping("allfood")
    public List<Fooddetails> getAllFood() {
        return fservice.getAllFood();
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateFoodRequest req) {
        fservice.update(req.getFood_name(), req.getPrice(), req.isAvailable());
    }

    @DeleteMapping("/delete")
    public void deleteFood(@RequestParam String food_name){
        fservice.deleteFood(food_name);
    }

}
