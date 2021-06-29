package com.ua.orders.services;

import com.ua.orders.models.SomeItem;

import java.util.List;

public interface SomeItemServices {

    void save(SomeItem someItem);

    SomeItem findLowestPrice(String someItemName);

    List<SomeItem> findAll();

    SomeItem findByID(int id);

    void deleteAllItems();
}
