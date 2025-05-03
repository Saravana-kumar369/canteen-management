package com.example.canteen_management.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.canteen_management.repo.OrderDetailsRepository;
import com.example.canteen_management.model.Orderdetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class orderdetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public Orderdetails saveOrder() {
        Orderdetails oentity=new Orderdetails();
        oentity.setOrderDate(LocalDateTime.now());
        return orderDetailsRepository.save(oentity);
    }

    public List<Orderdetails> getAllOrders() {
        return orderDetailsRepository.findAll();
    }

    public Orderdetails getOrderById(int id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }
}
