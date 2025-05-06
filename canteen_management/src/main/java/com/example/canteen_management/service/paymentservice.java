package com.example.canteen_management.service;

import com.example.canteen_management.model.Payment;
import com.example.canteen_management.repo.PaymentRepo;

public class Paymentservice {

    private PaymentRepo paymentrepo;

    public Payment getpaymentByUserid(int user){
        return paymentrepo.findByUserId(user);
    }

    public Payment savePayment(Payment payment) {
        return paymentrepo.save(payment);
    }
}