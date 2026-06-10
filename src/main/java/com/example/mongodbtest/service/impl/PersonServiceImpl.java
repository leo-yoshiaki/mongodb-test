package com.example.mongodbtest.service.impl;

import com.example.mongodbtest.model.Person;
import com.example.mongodbtest.repository.PersonRepository;
import com.example.mongodbtest.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Person create(Person person) {
        person.setId(null);
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
