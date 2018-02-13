package com.recreations.service;

import com.recreations.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAll();

    Person get(int personID);

    void add(Person newPerson);

    int remove(Person person);

    void update(Person person);
}
