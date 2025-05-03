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
        private Integer ItemId;
        
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "orderId")
        private orderdetails orderId;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "foodId")
        private Fooddetails foodId;

        private int quantity;
        private int subtotal;
    
        public int getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(int subtotal) {
            this.subtotal = subtotal;
        }

        public orderitems(int ItemId,orderdetails orderId, Fooddetails foodId, int quantity, String orderDate,int subtotal) {
            this.ItemId = ItemId;
            this.orderId = orderId;
            this.foodId = foodId;
            this.quantity = quantity;
            this.subtotal = subtotal;
        }
    
        public orderitems() {
            //TODO Auto-generated constructor stub
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
    
    

        public orderitems getOrderDetails() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getOrderDetails'");
        }
    
}
