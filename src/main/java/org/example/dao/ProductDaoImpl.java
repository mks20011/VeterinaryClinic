package org.example.dao;

import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Product> allProduct() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product").list();
    }

    @Override
    public void add(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
    }

    @Override
    public void edit(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public Product getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }
}
