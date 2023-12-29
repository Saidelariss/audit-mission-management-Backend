package com.example.demo.repository;

import com.example.demo.entities.Control;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ControlRepository extends MongoRepository<Control, String> {
}
