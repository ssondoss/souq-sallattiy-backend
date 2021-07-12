package com.sallatiy.sallatiy.services;

import com.sallatiy.sallatiy.models.Product;
import com.sallatiy.sallatiy.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public void addProduct(Product product) {
        // change product
        repo.add(product);
    }

    public List<Product> getAll() {
        return repo.getAll();
    }

    public void delete(String id) {
        repo.delete(id);
    }

    public Product getById(String id) {
        Optional<Product> byID = repo.getByID(id);
        if (byID.isPresent()) {
            return byID.get();
        } else {
            throw new RuntimeException("PRODUCT_NOT_FOUND");
        }
    }
}
