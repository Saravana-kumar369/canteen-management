package com.example.canteen_management.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
        
    private int orderId;
    private String paymentDate;
    private String paymentStatus;
    private double amount;
    
        public payment(int paymentId, int orderId, String paymentDate, String paymentStatus, double amount) {
            this.paymentId = paymentId;
            this.orderId = orderId;
            this.paymentDate = paymentDate;
            this.paymentStatus = paymentStatus;
            this.amount = amount;
        }
    
        // Getters and Setters for each field
        public int getPaymentId() {
            return paymentId;
        }
    
        public void setPaymentId(int paymentId) {
            this.paymentId = paymentId;
        }
    
        public int getOrderId() {
            return orderId;
        }
    
        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }
    
        public String getPaymentDate() {
            return paymentDate;
        }
    
        public void setPaymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
        }
    
        public String getPaymentStatus() {
            return paymentStatus;
        }
    
        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }
    
        public double getAmount() {
            return amount;
        }
    
        public void setAmount(double amount) {
            this.amount = amount;
        }
}
