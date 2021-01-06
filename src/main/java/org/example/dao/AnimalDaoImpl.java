package org.example.dao;

import org.example.model.Animal;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalDaoImpl implements AnimalDao{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<Animal> allAnimal() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Animal").list();
    }

    @Override
    public void add(Animal animal) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(animal);
    }

    @Override
    public void delete(Animal animal) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(animal);
    }

    @Override
    public void edit(Animal animal) {
        Session session = sessionFactory.getCurrentSession();
        session.update(animal);
    }

    @Override
    public Animal getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Animal.class, id);
    }
}
