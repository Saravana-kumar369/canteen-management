package com.example.canteen_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.canteen_management.model.orderitems;

public interface orderitemsRepo extends JpaRepository <orderitems ,Integer> {

     
}
