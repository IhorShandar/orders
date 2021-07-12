package com.ua.orders.dao;

import com.ua.orders.models.SomeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SomeItemDao extends JpaRepository<SomeItem, Integer> {

    @Query(value = "select * from orders.some_item as item where item.name = :name order by item.price_by_one Limit 1", nativeQuery = true)
    SomeItem findFirstByName(String name);
}
