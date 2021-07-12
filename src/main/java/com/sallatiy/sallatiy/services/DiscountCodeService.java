package com.sallatiy.sallatiy.services;

import com.sallatiy.sallatiy.models.DiscountCode;
import com.sallatiy.sallatiy.repos.DiscountCodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscountCodeService {

    @Autowired
    private DiscountCodeRepo repo;

    public void add(DiscountCode discountCode) {
        repo.add(discountCode);
    }
    public List<DiscountCode> getAll() {
        return repo.getAll();
    }

    public DiscountCode getById(String id) {
        Optional<DiscountCode> byID = repo.getByID(id);
        if (byID.isPresent()) {
            return byID.get();

        } else throw new RuntimeException("DISCOUNTCODE_NOT_FOUND");
    }

    public void delete(String id) {
        repo.delete(id);
    }


}
