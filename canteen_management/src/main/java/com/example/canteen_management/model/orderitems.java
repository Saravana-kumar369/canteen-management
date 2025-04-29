package com.example.canteen_management.model;

public class orderitems {
        
        private int orderId;
        private int foodId;
        private int quantity;
        private String orderDate;
        private String status;
        private String paymentStatus;

    
        public orderitems(int orderId, int foodId, int quantity, String orderDate, String status, String paymentStatus) {
            this.orderId = orderId;
            this.foodId = foodId;
            this.quantity = quantity;
            this.orderDate = orderDate;
            this.status = status;
            this.paymentStatus = paymentStatus;
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
    
}
