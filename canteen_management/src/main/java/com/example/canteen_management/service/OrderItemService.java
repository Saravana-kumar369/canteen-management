package com.example.canteen_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.canteen_management.DTO.Orderitemsdto;
import com.example.canteen_management.model.Fooddetails;
import com.example.canteen_management.model.Orderdetails;
import com.example.canteen_management.model.Orderitems;
import com.example.canteen_management.repo.Foodrepo;
import com.example.canteen_management.repo.OrderDetailsRepository;
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

    @Autowired
    private OrderDetailsRepository orepo;
    public String saveItem(ArrayList<Orderitemsdto> item) {
        Orderitems oent=new Orderitems();
        int length=item.size();
        for(int ind=0;ind<length;ind++)
        {
            Integer foodid=item.get(ind).getFoodId();
            Fooddetails food=frepo.findById(foodid).orElseThrow();
            oent.setFoodId(food);
            Integer orderid=item.get(ind).getOrderId();
            Orderdetails order=orepo.findById(orderid).orElseThrow();
            oent.setOrderId(order);
            oent.setQuantity(item.get(ind).getQuantity());
            oent.setSubtotal(item.get(ind).getSubtotal());
            orderItemRepository.save(oent);
        }
        return "Added";
    }

    public List<Orderitems> getItemsByOrderId(int orderId) {
        return orderItemRepository.findAll()
                .stream()
                .filter(i -> i.getOrderDetails().getOrderId().equals(orderId))
                .toList();
    }
}
    