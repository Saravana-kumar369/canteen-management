package com.example.canteen_management.DTO;

import lombok.Data;

@Data
public class Orderitemsdto {
    private Integer orderId;
    private Integer foodId;
    private int quantity;
    private int subtotal;

    
    public Orderitemsdto() {
    }
    public Orderitemsdto( Integer orderId, Integer foodId, int quantity, int subtotal) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

}
