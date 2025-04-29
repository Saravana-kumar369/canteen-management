package com.example.canteen_management.model;

public class image {
        
        private int imageId;
        private String imagePath;
        private String imageType;
        private int foodId;
    
        public image(int imageId, String imagePath, String imageType, int foodId) {
            this.imageId = imageId;
            this.imagePath = imagePath;
            this.imageType = imageType;
            this.foodId = foodId;
        }
    
        // Getters and Setters for each field
        public int getImageId() {
            return imageId;
        }
    
        public void setImageId(int imageId) {
            this.imageId = imageId;
        }
    
        public String getImagePath() {
            return imagePath;
        }
    
        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }
    
        public String getImageType() {
            return imageType;
        }
    
        public void setImageType(String imageType) {
            this.imageType = imageType;
        }
    
        public int getFoodId() {
            return foodId;
        }
    
        public void setFoodId(int foodId) {
            this.foodId = foodId;
        }
}
