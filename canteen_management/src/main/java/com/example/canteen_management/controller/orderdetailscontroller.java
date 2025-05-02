package com.example.canteen_management.controller;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.canteen_management.model.orderdetails;

import com.example.canteen_management.service.orderdetailsService;

public class orderdetailscontroller {
    
    private orderdetailsService orderservice;
    @PostMapping("/add")
    public orderdetails save()
    {
        return orderservice.saveOrder();
    }
    
}
