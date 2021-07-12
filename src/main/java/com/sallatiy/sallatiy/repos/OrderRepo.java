package com.sallatiy.sallatiy.repos;

import com.sallatiy.sallatiy.models.Order;
import com.sallatiy.sallatiy.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderRepo {
    @Autowired
    private OrderMongoRepo repo;

    public void create(Order order) {
        repo.save(order);
    }

    public List<Order> getAll() {
        return repo.findAll();
    }

    public Optional<Order> getByID(String id) {
        return repo.findById(id);
    }
}
