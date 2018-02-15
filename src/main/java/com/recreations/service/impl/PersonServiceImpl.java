package com.recreations.service.impl;

import com.recreations.repository.PersonDAO;
import com.recreations.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recreations.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonDAO personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person get(Integer personID) {
        return personRepository.findOne(personID);
    }

    @Override
    public void add(Person newPerson) {
        personRepository.save(newPerson);
    }

    @Override
    public Integer remove(Person person) {
        personRepository.delete(person);
        return person.getIdOsoba();
    }

    @Override
    public void update(Person person) {
        personRepository.saveAndFlush(person);
    }
}
