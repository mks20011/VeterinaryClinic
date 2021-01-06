package org.example.dao;


import org.example.model.Record;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordDaoImpl implements RecordDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Record> allRecord() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Record ").list();
    }

    @Override
    public void add(Record record) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(record);
    }

    @Override
    public void delete(Record record) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(record);
    }

    @Override
    public void edit(Record record) {
        Session session = sessionFactory.getCurrentSession();
        session.update(record);
    }

    @Override
    public Record getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Record.class, id);
    }
}
