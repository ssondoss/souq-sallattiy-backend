package com.sallatiy.sallatiy.rest;

import com.sallatiy.sallatiy.models.Order;
import com.sallatiy.sallatiy.models.Product;
import com.sallatiy.sallatiy.services.OrderService;
import com.sallatiy.sallatiy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    OrderService service;
    @PostMapping
    public void create(@RequestBody Order order){

        service.createOrder(order);
    }

    @GetMapping
    public List<Order> getAll(){
        return  service.getAll();
    }
    @GetMapping("{/id}")
    public Order getByID(@PathVariable("id")   String id){
        return  service.getByID(id);
    }
}
