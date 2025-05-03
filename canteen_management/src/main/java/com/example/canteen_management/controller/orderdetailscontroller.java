package com.example.canteen_management.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.canteen_management.model.orderdetails;
import com.example.canteen_management.service.orderdetailsService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(path = "/order")
public class Orderdetailscontroller {
    private final orderdetailsService orderservice;

    public Orderdetailscontroller(orderdetailsService orderservice) {
        this.orderservice = orderservice;
    }
    
    @PostMapping("/add")
    public orderdetails save()
    {
        return orderservice.saveOrder();
    }
    
}
