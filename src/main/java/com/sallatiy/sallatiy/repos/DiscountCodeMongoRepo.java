package com.sallatiy.sallatiy.repos;

import com.sallatiy.sallatiy.models.DiscountCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountCodeMongoRepo extends MongoRepository<DiscountCode, String> {
}
