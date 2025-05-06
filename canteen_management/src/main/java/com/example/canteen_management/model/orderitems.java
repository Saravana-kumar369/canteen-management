package com.example.canteen_management.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orderitems {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer ItemId;
        
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "orderId")
        private Orderdetails orderId;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "foodId")
        private Fooddetails foodId;

        private int quantity;
        private int subtotal;
    
        
        public Orderitems() {
        }

        public int getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(int subtotal) {
            this.subtotal = subtotal;
        }

        public Orderitems(int ItemId,Orderdetails orderId, Fooddetails foodId, int quantity, String orderDate,int subtotal) {
            this.ItemId = ItemId;
            this.orderId = orderId;
            this.foodId = foodId;
            this.quantity = quantity;
            this.subtotal = subtotal;
        }

        public int getItemId() {
            return ItemId;
        }

        public void setItemId(int itemId) {
            ItemId = itemId;
        }

        // Getters and Setters for each field
        public Orderdetails getOrderId() {
            return orderId;
        }
    
        public void setOrderId(Orderdetails orderId) {
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
    
    

        public Orderitems getOrderDetails() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getOrderDetails'");
        }
    
}