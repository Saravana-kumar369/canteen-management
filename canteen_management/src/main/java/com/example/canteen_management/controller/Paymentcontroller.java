package com.example.canteen_management.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.canteen_management.model.Payment;
import com.example.canteen_management.service.Paymentservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins ="http://localhost:5173")
@RestController

@RequestMapping("/payment")
public class Paymentcontroller {
    private Paymentservice paymentservice;

    @PostMapping("/add")
    public Payment savePayment(@RequestBody Payment payment) {
        return paymentservice.savePayment(payment);
    }
    
}
