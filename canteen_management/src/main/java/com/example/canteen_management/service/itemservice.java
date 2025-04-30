package com.example.canteen_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.canteen_management.model.orderitems;
import com.example.canteen_management.repo.Servicerepo;

@Service
public class itemservice {
    @Autowired
    private Servicerepo servicerepo;
    
    public List<orderitems> getitems(int orderid){
        return servicerepo.getitems(orderid);
    }
}
