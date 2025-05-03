package com.example.canteen_management.service;

import com.example.canteen_management.model.Payment;
import com.example.canteen_management.repo.PaymentRepo;

public class Paymentservice {

    private PaymentRepo paymentrepo;

    public void savepayment(Payment paymentdata){
        paymentrepo.save(paymentdata);
    }

    public Payment getpaymentByUserid(int user){
        return paymentrepo.findByUserId(user);
    }
}