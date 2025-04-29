package com.example.canteen_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class user {
        @Id
        private int userId;
        private String userName;
        private String userPassword;
        private String userPhone;
    
        public user(int userId, String userName,String userPassword, String userPhone) {
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
