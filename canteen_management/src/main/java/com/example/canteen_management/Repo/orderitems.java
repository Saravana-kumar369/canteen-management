package com.example.canteen_management.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.canteen_management.model.orderdetails;
@Repository
public interface orderitems extends JpaRepository<orderitems, Integer>{
    
    List<orderdetails> findByStatus(String status);
    
    List<orderdetails> findByFoodId(int foodId);
}
