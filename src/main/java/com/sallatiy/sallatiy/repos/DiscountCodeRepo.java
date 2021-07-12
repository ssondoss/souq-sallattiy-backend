package com.sallatiy.sallatiy.repos;


import com.sallatiy.sallatiy.models.DiscountCode;
import com.sallatiy.sallatiy.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DiscountCodeRepo {
    @Autowired
    private DiscountCodeMongoRepo repo;

    public void add(DiscountCode discountCode) {
        repo.save(discountCode);
    }

    public List<DiscountCode> getAll() {
        return repo.findAll();
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    public Optional<DiscountCode> getByID(String id) {
        return repo.findById(id);
    }
}
