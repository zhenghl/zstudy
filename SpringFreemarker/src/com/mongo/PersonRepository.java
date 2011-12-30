package com.mongo;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import org.apache.log4j.Logger;

@Repository
public class PersonRepository {

    static final Logger logger = Logger.getLogger(PersonRepository.class);

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Person> logAllPersons() {
        List<Person> results = mongoTemplate.findAll(Person.class);
        logger.info("### Total amount of persons: " + results.size());
        return results;
    }

    /**
     * Calculates the average age of a {@link Person}.
     *
     * @return the average age
     */
    public int getAvarageAgeOfPerson() {
        List<Person> results = mongoTemplate.findAll(Person.class);
        int age = 0;
        Iterator<Person> personIterator = results.iterator();
        while (personIterator.hasNext()) {
            Person nextPerson = personIterator.next();
            age += nextPerson.getAge();
        }
        return age / results.size();
    }

    public void insertPersonWithNameJohnAndRandomAge() {
        //get random age between 1 and 100
        double age = Math.ceil(Math.random() * 100);

        Person p = new Person("John", (int) age);

        mongoTemplate.insert(p);
        
    }

    /**
     * Create a {@link Person} collection if the collection does not already exists
     */
    public void createPersonCollection() {
        if (!mongoTemplate.collectionExists(Person.class)) {
            mongoTemplate.createCollection(Person.class);
        }
    }

    /**
     * Drops the {@link Person} collection if the collection does already exists
     */
    public void dropPersonCollection() {
        if (mongoTemplate.collectionExists(Person.class)) {
            mongoTemplate.dropCollection(Person.class);
        }
    }
}
  