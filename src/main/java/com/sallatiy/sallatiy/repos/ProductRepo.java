package com.sallatiy.sallatiy.repos;


import com.sallatiy.sallatiy.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepo {
    @Autowired
    private ProductMongoRepo repo;

    public  void add(Product product){
        repo.save(product);
    }

    public List<Product> getAll(){
        return repo.findAll();
    }

    public Optional<Product> getByID(String id){
        return  repo.findById(id);
    }

    public void  delete(String id){
        repo.deleteById(id);
    }

}
