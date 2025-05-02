package com.example.canteen_management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.canteen_management.model.Fooddetails;


@Repository
public interface Foodrepo extends JpaRepository<Fooddetails, Integer> {

    @Modifying
    @Query("UPDATE Fooddetails f SET f.price = :price, f.isAvailable = :isAvailable WHERE f.food_name = :food_name")
    void updateByFoodName(
        @Param("food_name") String food_name,
        @Param("price") int price,
        @Param("isAvailable") boolean isAvailable
    );

    @Modifying
    @Query("DELETE FROM Fooddetails f WHERE f.food_name = :food_name")
    void deleteByname(@Param("food_name") String food_name);
    
}
