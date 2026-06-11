package com.example.mongodbtest;

import com.example.mongodbtest.model.Person;
import com.example.mongodbtest.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers(disabledWithoutDocker = true)
@SpringBootTest
class PersonRepositoryTest {

    @Container
    static final MongoDBContainer mongoDBContainer = new MongoDBContainer(
            DockerImageName.parse("mongo:7.0")
    );

    @DynamicPropertySource
    static void mongoProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
        registry.add("spring.data.mongodb.database", () -> "people_db");
    }

    @Autowired
    private PersonRepository personRepository;

    @Test
    void shouldSaveAndFindPersonUsingMongoContainer() {
        personRepository.deleteAll();

        Person person = Person.builder()
                .name("Pipeline CI")
                .email("pipeline.ci@example.com")
                .build();

        personRepository.save(person);

        List<Person> people = personRepository.findAll();

        assertThat(people)
                .hasSize(1)
                .first()
                .extracting(Person::getName, Person::getEmail)
                .containsExactly("Pipeline CI", "pipeline.ci@example.com");
    }
}
