package org.example.dao;

import org.example.model.Animal;
import org.example.model.Person;

import java.util.List;

public interface AnimalDao {
    List<Animal> allAnimal();
    void add(Animal animal);
    void delete(Animal animal);
    void edit(Animal animal);
    Animal getById(int id);
}
