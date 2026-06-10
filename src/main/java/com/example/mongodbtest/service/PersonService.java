package com.example.mongodbtest.service;

import com.example.mongodbtest.model.Person;

import java.util.List;

public interface PersonService {

    Person create(Person person);

    List<Person> findAll();
}
