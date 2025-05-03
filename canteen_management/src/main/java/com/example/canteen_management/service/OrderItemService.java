package com.example.canteen_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.canteen_management.model.Fooddetails;
import com.example.canteen_management.model.Orderitems;
import com.example.canteen_management.repo.Foodrepo;
import com.example.canteen_management.repo.OrderitemsRepo;

// @Service
// public class itemservice {
//     @Autowired
//     private Servicerepo servicerepo;
    
//     public List<orderitems> getitems(int orderid){
//         return servicerepo.getitems(orderid);
//     }
// }

@Service
public class OrderItemService {
    @Autowired
    private OrderitemsRepo orderItemRepository;

    @Autowired
    private Foodrepo frepo;
    public Orderitems saveItem(Orderitems item) {
        Fooddetails entity=frepo.findById(item.getFoodId().getFoodid()).orElseThrow();
        Integer price=entity.getPrice();
        Integer total=price*item.getQuantity();
        Orderitems oent=new Orderitems();
        oent.setSubtotal(total);
        oent.setQuantity(item.getQuantity());
        oent.setOrderId(item.getOrderId());
        oent.setFoodId(item.getFoodId());
        return orderItemRepository.save(oent);
    }

    public List<Orderitems> getItemsByOrderId(int orderId) {
        return orderItemRepository.findAll()
                .stream()
                .filter(i -> i.getOrderDetails().getOrderId().equals(orderId))
                .toList();
    }
}
    