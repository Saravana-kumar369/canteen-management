package com.example.canteen_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.canteen_management.model.Orderitems;

public interface OrderitemsRepo extends JpaRepository <Orderitems ,Integer> {

     
}
