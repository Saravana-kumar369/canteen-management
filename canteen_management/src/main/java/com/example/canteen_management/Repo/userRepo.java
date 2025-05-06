package com.example.canteen_management.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.canteen_management.model.User;

@Repository
public interface UserRepo extends JpaRepository <User,Integer> {
    @Query("SELECT u FROM User u WHERE u.userName = :userName AND u.userPassword = :userPassword")
    User loginUser(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
