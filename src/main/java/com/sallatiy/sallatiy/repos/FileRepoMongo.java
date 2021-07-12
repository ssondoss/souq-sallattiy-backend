package com.sallatiy.sallatiy.repos;
import com.sallatiy.sallatiy.models.File;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepoMongo extends MongoRepository<File, String> {
}