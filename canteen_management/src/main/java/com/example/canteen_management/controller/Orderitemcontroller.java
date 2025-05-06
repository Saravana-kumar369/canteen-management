package com.example.canteen_management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.canteen_management.DTO.Orderitemsdto;
// import com.example.canteen_management.model.orderdetails;
import com.example.canteen_management.model.Orderitems;
import com.example.canteen_management.service.OrderItemService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins ="http://localhost:5173")
@RequestMapping("/item")
@RestController
public class Orderitemcontroller {
    @Autowired
    private OrderItemService itemservice;

    @GetMapping("/id/{orderId}")
    public List<Orderitems> getOrderId(@PathVariable Integer orderId) {
        return itemservice.getItemsByOrderId(orderId);
    }

    @PostMapping("/add")
    public String saveOrderitems(@RequestBody ArrayList<Orderitemsdto> item) {
        System.out.println("hello");
        return itemservice.saveItem(item);
    }
}
