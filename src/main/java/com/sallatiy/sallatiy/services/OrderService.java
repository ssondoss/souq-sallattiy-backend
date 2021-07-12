package com.sallatiy.sallatiy.services;

import com.sallatiy.sallatiy.models.Order;
import com.sallatiy.sallatiy.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepo repo;
    public void createOrder(Order order) {
        repo.create(order);
    }

    public List<Order> getAll() {
        return  repo.getAll();
    }

    public Order getByID(String id) {
        Optional<Order> byID = repo.getByID(id);
        if(byID.isPresent()){
            return byID.get();
        }
        else
            throw new RuntimeException("ORDER_NOT_FOUND");
    }
}
