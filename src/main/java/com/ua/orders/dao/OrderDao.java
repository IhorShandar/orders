package com.ua.orders.dao;

import com.ua.orders.models.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<MyOrder, Integer> {

}
