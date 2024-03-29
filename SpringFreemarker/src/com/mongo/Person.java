package com.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
	
    private String personId;

    private String name;
    private String homeTown;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(final String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(final String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return "Person [id=" + personId + ", name=" + name + ", age=" + age + ", home town=" + homeTown + "]";
    }

}