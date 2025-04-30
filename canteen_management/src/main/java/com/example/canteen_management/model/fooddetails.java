package com.example.canteen_management.model;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

// import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Fooddetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodid;

    private String food_name;

    private int price;

    @Enumerated (EnumType.STRING)
    private  Category category;

    private boolean isAvailable;
    @OneToMany(mappedBy = "foodId")
    private List<orderitems> orderItemsList;
    
    public Fooddetails() {}

    public Fooddetails(int foodid,String food_name,int price,Category category,boolean isAvailable){
        this.foodid=foodid;
        this.food_name=food_name;
        this.price=price;
        this.category=category;
        this.isAvailable=isAvailable;
    }
    public enum Category{
        VEG,
        NON_VEG,
    }

}
