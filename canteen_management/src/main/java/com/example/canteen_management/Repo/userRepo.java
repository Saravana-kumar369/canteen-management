package com.example.canteen_management.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.canteen_management.model.user;

@Repository
public interface userRepo extends JpaRepository <user,Integer> {
    user findByUserId(int userId);
}
