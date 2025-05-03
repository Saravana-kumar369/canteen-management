package com.example.canteen_management.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.canteen_management.model.Orderdetails;
import com.example.canteen_management.service.OrderdetailsService;

@RestController
@RequestMapping("/order")
public class Orderdetailscontroller {
    
    // private orderdetailsService orderservice;
    private final OrderdetailsService orderservice;

    public Orderdetailscontroller(OrderdetailsService orderservice) {
        this.orderservice = orderservice;
    }

    @PostMapping("/add")
    public Orderdetails save()
    {
        return orderservice.saveOrder();
    }
    
}
