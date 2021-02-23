package org.example.service;

import org.example.dao.AnimalDao;
import org.example.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private AnimalDao animalDao;


    @Autowired
    public void setAnimalDao(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    @Transactional
    public List<Animal> allAnimal() {
        return animalDao.allAnimal();
    }

    @Override
    @Transactional
    public void add(Animal animal) {
animalDao.add(animal);
    }

    @Override
    @Transactional
    public void delete(Animal animal) {
        animalDao.delete(animal);
    }

    @Override
    @Transactional
    public void edit(Animal animal) {
        animalDao.edit(animal);
    }

    @Override
    @Transactional
    public Animal getById(int id) {
        return animalDao.getById(id);
    }

    @Override
    public void fillAnimal(Animal animal, int personId) {
       // animal.setPerson(personService.getById(personId));
        animal.setIdPerson(personId);
    }
}
