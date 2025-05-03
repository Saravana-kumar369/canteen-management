package com.example.canteen_management.DTO;

import lombok.Data;

@Data
public class UpdateFoodRequest {
    private String food_name;
    private int price;
    private boolean isAvailable;
}

