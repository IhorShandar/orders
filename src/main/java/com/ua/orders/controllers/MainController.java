package com.ua.orders.controllers;

import com.ua.orders.models.MyOrder;
import com.ua.orders.models.SomeItem;
import com.ua.orders.services.OrderServicesImpl;
import com.ua.orders.services.SomeItemServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@RestController
public class MainController {

    @Autowired
    OrderServicesImpl orderServices;

    @Autowired
    SomeItemServicesImpl someItemServices;

    @PostMapping("/createOrder")
    public MyOrder createOrder(@RequestBody MyOrder myOrder) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                myOrder.setValid("Not Valid");
                orderServices.save(myOrder);
                System.out.println("Order with id = " + myOrder.getID() + " can be deleted");
            }
        };

        try {
            SomeItem someItem = someItemServices.findByID(myOrder.getItem().getID());
            myOrder.setItem(someItem);
            myOrder.setPrice(someItem.getPriceByOne() * myOrder.getQuantity());
            myOrder.setNameItem(myOrder.getItem().getName());
            myOrder.setValid("Valid");
            orderServices.save(myOrder);

            timer.schedule(timerTask, 600 * 1000); //valid for 10 minutes
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Item with id = " + myOrder.getItem().getID() + " doesn't exist");
            return null;
        }

        return myOrder;
    }

    @DeleteMapping("deleteAllItems")
    public String deleteItems(){
        someItemServices.deleteAllItems();
        return "All items was deleted";
    }

    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id) {
        try {
            if (orderServices.findById(id).getValid().equals("Not Valid")) {
                orderServices.deleteById(id);
                return "Order deleted";
            } else {
                return "Order is valid";
            }
        } catch (NullPointerException ex) {
            return "Order with id = " + id + " doesn't exist";
        }
    }

    @PostMapping("/createItem")
    public SomeItem createItem(@RequestBody SomeItem someItem) {
        someItemServices.save(someItem);
        return someItem;
    }

    @GetMapping("/minPrice/{nameItem}")
    public List<SomeItem> minPrice(@PathVariable String nameItem) {
        List<SomeItem> items = new ArrayList<>();
        SomeItem lowestPrice = someItemServices.findLowestPrice(nameItem);
        if (lowestPrice != null) {
            items.add(lowestPrice);
        } else {
            items = someItemServices.findAll();
        }
        return items;
    }

}
