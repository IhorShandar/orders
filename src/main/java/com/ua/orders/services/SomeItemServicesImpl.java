package com.ua.orders.services;

import com.ua.orders.dao.SomeItemDao;
import com.ua.orders.models.SomeItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SomeItemServicesImpl implements SomeItemServices {

    private SomeItemDao someItemDao;

    @Override
    public void save(SomeItem someItem) {
        someItemDao.save(someItem);
    }

    @Override
    public SomeItem findLowestPrice(String someItemName) {
        return someItemDao.findFirstByName(someItemName);
    }

    @Override
    public List<SomeItem> findAll() {
        return someItemDao.findAll();
    }

    @Override
    public SomeItem findByID(int id) {
        return someItemDao.findById(id).orElse(null);
    }

    @Override
    public void deleteAllItems() {
        someItemDao.deleteAll();
    }
}
