package com.example.canteen_management.repo;
import java.util.List;

// import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.canteen_management.model.orderitems;

@Repository
public interface Servicerepo extends JpaRepository<orderitems, Integer> {

    @Query("SELECT i FROM orderitems i WHERE i.orderId.orderId = ?1")
    public List<orderitems> getitems(int orderid);
}
