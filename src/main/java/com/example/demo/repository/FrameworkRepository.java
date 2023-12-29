package com.example.demo.repository;

import com.example.demo.entities.Framework;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FrameworkRepository extends MongoRepository<Framework, String> {

}
