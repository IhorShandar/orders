package com.ua.orders.services;

import com.ua.orders.models.MyOrder;
import org.springframework.stereotype.Service;

@Service
public interface OrderServices {

    void save(MyOrder myOrder);

    void deleteById(int id);

    MyOrder findById(int id);
}
