package com.example.canteen_management.Repo;

import com.example.canteen_management.model.orderdetails;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailsRepository extends JpaRepository<orderdetails, Integer> {
    // List<orderdetails> findByUserUserId(Integer userId);
}

