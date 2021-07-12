package com.sallatiy.sallatiy.repos;

import com.sallatiy.sallatiy.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMongoRepo extends MongoRepository<Order, String> {

}
