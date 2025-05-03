package com.example.canteen_management.repo;

import com.example.canteen_management.model.Orderdetails;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailsRepository extends JpaRepository<Orderdetails, Integer> {
    // List<orderdetails> findByUserUserId(Integer userId);
}

