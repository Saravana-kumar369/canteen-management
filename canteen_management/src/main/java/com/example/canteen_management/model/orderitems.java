package com.example.canteen_management.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class orderitems {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int ItemId;
        
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "orderId")
        private orderdetails orderId;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "foodId")
        private Fooddetails foodId;

        private int quantity;

        private String orderDate;

        private String status;

        private String paymentStatus;

    
        public orderitems(int ItemId,orderdetails orderId, Fooddetails foodId, int quantity, String orderDate, String status, String paymentStatus) {
            this.ItemId = ItemId;
            this.orderId = orderId;
            this.foodId = foodId;
            this.quantity = quantity;
            this.orderDate = orderDate;
            this.status = status;
            this.paymentStatus = paymentStatus;
        }
    
        public int getItemId() {
            return ItemId;
        }

        public void setItemId(int itemId) {
            ItemId = itemId;
        }

        // Getters and Setters for each field
        public orderdetails getOrderId() {
            return orderId;
        }
    
        public void setOrderId(orderdetails orderId) {
            this.orderId = orderId;
        }
    
        public Fooddetails getFoodId() {
            return foodId;
        }
    
        public void setFoodId(Fooddetails foodId) {
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
