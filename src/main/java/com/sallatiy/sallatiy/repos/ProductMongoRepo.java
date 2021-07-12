package com.sallatiy.sallatiy.repos;

import com.sallatiy.sallatiy.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMongoRepo extends MongoRepository<Product , String> {

}