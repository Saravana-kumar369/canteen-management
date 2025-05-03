package com.example.canteen_management.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.canteen_management.model.User;

@Repository
public interface UserRepo extends JpaRepository <User,Integer> {
    
}
