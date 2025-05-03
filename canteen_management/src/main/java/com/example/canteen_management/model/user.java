package com.example.canteen_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int userId;

        private String userName;
        private String userPassword;
        
        @Column(unique = true)
        private String userPhone;
    
        public User(int userId, String userName,String userPassword, String userPhone) {
            this.userId = userId;
            this.userName = userName;
            this.userPassword = userPassword;
            this.userPhone = userPhone;
        }
    
        // Getters and Setters for each field
        public int getUserId() {
            return userId;
        }
    
        public void setUserId(int userId) {
            this.userId = userId;
        }
    
        public String getUserName() {
            return userName;
        }
    
        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPhone() {
            return userPhone;
        }
    
        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }
    
        public String getUserPassword() {
            return userPassword;
        }

        
    
        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }
}
