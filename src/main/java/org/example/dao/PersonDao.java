package org.example.dao;

import org.example.model.Person;

import java.util.List;

public interface PersonDao {
    List<Person> allPerson();
    void add(Person person);
    void delete(Person person);
    void edit(Person person);
    Person getById(int id);
    Person  getByNumberPhone(String numberPhone);
}
