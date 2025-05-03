package com.example.canteen_management.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.canteen_management.model.orderdetails;
import com.example.canteen_management.service.orderdetailsService;

@RestController
@RequestMapping("/order")
public class orderdetailscontroller {
    
    // private orderdetailsService orderservice;
    private final orderdetailsService orderservice;

    public orderdetailscontroller(orderdetailsService orderservice) {
        this.orderservice = orderservice;
    }

    @PostMapping("/add")
    public orderdetails save()
    {
        return orderservice.saveOrder();
    }
    
}
