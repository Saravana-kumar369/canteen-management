package com.example.canteen_management.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.canteen_management.Repo.OrderDetailsRepository;
import com.example.canteen_management.model.orderdetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class orderdetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public orderdetails saveOrder() {
        orderdetails oentity=new orderdetails();
        oentity.setOrderDate(LocalDateTime.now());
        return orderDetailsRepository.save(oentity);
    }

    public List<orderdetails> getAllOrders() {
        return orderDetailsRepository.findAll();
    }

    public orderdetails getOrderById(int id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }
}
