package com.sallatiy.sallatiy.rest;

import com.sallatiy.sallatiy.models.Product;
import com.sallatiy.sallatiy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService service;
    @PostMapping
    public void add(@RequestBody Product product){
        service.addProduct(product);
    }

    @GetMapping
    public List<Product> getAll(){
     return service.getAll();
    }

    @GetMapping("{/id}")
    public Product getByID(@PathVariable("id") String id){
        return service.getById(id);
    }
    @DeleteMapping("{/id}")
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }

}
