package com.ua.orders.dao;

import com.ua.orders.models.SomeItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SomeItemDao extends JpaRepository<SomeItem, Integer> {

    SomeItem findByName(String name);
    List<SomeItem> findAllByName(String name);
}
