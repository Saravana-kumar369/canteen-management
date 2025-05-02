package com.example.canteen_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.example.canteen_management.model.orderdetails;
import com.example.canteen_management.model.orderitems;
import com.example.canteen_management.service.OrderItemService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins ="http://localhost:5173")
@RequestMapping("/item")
@RestController
public class orderitem {

    private OrderItemService itemservice;

    @GetMapping("/id/{orderId}")
    public List<orderitems> getOrderId(@PathVariable Integer orderId) {
        return itemservice.getItemsByOrderId(orderId);
    }

    @PostMapping("/add")
    public orderitems saveOrderitems(@RequestBody orderitems item) {
        return itemservice.saveItem(item);
    }
}
