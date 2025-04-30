package com.example.canteen_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.example.canteen_management.model.orderdetails;
import com.example.canteen_management.model.orderitems;
import com.example.canteen_management.service.itemservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins ="http://localhost:5173")
@RequestMapping("/item")
@RestController
public class item {

    private itemservice itemservice;

    @GetMapping("/id/{orderId}")
    public List<orderitems> getOrderId(@PathVariable Integer orderId) {
        return itemservice.getitems(orderId);
    }
}
