package com.example.canteen_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.canteen_management.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

   @Query("SELECT p FROM Payment p WHERE p.user.id = :userId")
    Payment findByUserId(@Param("userId") int userId);

}