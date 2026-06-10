package com.example.mongodbtest.repository;

import com.example.mongodbtest.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
