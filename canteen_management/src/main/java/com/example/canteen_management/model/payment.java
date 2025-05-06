package com.example.canteen_management.model;


import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
        
    @JoinColumn(name = "orderId")
    @OneToOne(cascade = CascadeType.ALL)
    private Orderdetails orderId;


    @JoinColumn(name = "userId")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


    private LocalDateTime paymentDate;


    private String paymentStatus="Pending";

    private double amount;
    
        public Payment(int paymentId, Orderdetails orderId, LocalDateTime paymentDate, String paymentStatus, double amount,User user) {
            this.paymentId = paymentId;
            this.orderId = orderId;
            this.paymentDate = paymentDate;
            this.paymentStatus = paymentStatus;
            this.amount = amount;
            this.user = user;
        }
    
        // Getters and Setters for each field
        public int getPaymentId() {
            return paymentId;
        }
    
        public void setPaymentId(int paymentId) {
            this.paymentId = paymentId;
        }
    
        public Orderdetails getOrderId() {
            return orderId;
        }
    
        public void setOrderId(Orderdetails orderId) {
            this.orderId = orderId;
        }
    
        public LocalDateTime getPaymentDate() {
            return paymentDate;
        }
    
        public void setPaymentDate(LocalDateTime paymentDate) {
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