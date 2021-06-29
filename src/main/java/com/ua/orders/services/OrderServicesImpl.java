package com.ua.orders.services;

import com.ua.orders.dao.OrderDao;
import com.ua.orders.models.MyOrder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServicesImpl implements OrderServices {

    private OrderDao orderDao;

    @Override
    public void save(MyOrder myOrder) {
        orderDao.save(myOrder);
    }

    @Override
    public void deleteById(int id) {
        orderDao.deleteById(id);
    }

    @Override
    public MyOrder findById(int id) {
        return orderDao.findById(id).orElse(null);
    }


}
