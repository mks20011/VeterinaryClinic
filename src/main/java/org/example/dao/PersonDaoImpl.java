package org.example.dao;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> allPerson() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Person").list();
    }

    @Override
    public void add(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Override
    public void delete(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(person);
    }

    @Override
    public void edit(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.update(person);
    }

    @Override
    public Person getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }
    @Override
    public Person getByNumberPhone(String numberPhone) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Person where numberPhone =:numberPhone",Person.class).
                setParameter("numberPhone", numberPhone).getSingleResult();
    }
}