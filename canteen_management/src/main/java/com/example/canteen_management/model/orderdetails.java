package com.example.canteen_management.model;

public class orderdetails {
    
    private int orderId;
    private int foodId;
    private int quantity;
    private String orderDate;
    private String status;
    private String paymentStatus;
    private String deliveryAddress;

    public orderdetails(int orderId, int foodId, int quantity, String orderDate, String status, String paymentStatus, String deliveryAddress) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.deliveryAddress = deliveryAddress;
    }

    // Getters and Setters for each field
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }   
    
}
