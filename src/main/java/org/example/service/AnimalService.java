package org.example.service;

import org.example.model.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> allAnimal();
    void add(Animal animal);
    void delete(Animal animal);
    void edit(Animal animal);
    Animal getById(int id);
    void fillAnimal(Animal animal, int personId);
}
