package com.sallatiy.sallatiy.rest;

import com.sallatiy.sallatiy.models.DiscountCode;
import com.sallatiy.sallatiy.models.Order;
import com.sallatiy.sallatiy.repos.DiscountCodeRepo;
import com.sallatiy.sallatiy.services.DiscountCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount-code")
@CrossOrigin(origins = "*")
public class DiscountCodeController {

    @Autowired
    private DiscountCodeService service;


    @PostMapping
    public void create(@RequestBody DiscountCode discountCode) {
        service.add(discountCode);
    }
    @GetMapping
    public List<DiscountCode> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DiscountCode getByID(@PathVariable("id") String id){
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}
