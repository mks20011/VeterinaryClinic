
package org.example.service;

import org.example.dao.PersonDao;
import org.example.model.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;
    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public List<Person> allPerson() {
        return personDao.allPerson();
    }

    @Override
    @Transactional
    public void add(Person person) {
        personDao.add(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        personDao.delete(person);
    }

    @Override
    @Transactional
    public void edit(Person person) {
        personDao.edit(person);
    }

    @Override
    @Transactional
    public Person getById(int id) {
        return personDao.getById(id);
    }

    @Override
    @Transactional
    public Person  getByNumberPhone(String numberPhone) {
        return personDao.getByNumberPhone(numberPhone);
    }
}
