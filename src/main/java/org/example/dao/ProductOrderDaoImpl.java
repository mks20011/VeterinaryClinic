package org.example.dao;

import org.example.model.ProductOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductOrderDaoImpl implements ProductOrderDao{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<ProductOrder> allProductOrder() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from ProductOrder").list();
    }

    @Override
    public void add(ProductOrder productOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(productOrder);
    }

    @Override
    public void delete(ProductOrder productOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(productOrder);
    }

    @Override
    public void edit(ProductOrder productOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.update(productOrder);
    }

    @Override
    public ProductOrder getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProductOrder.class,id);
    }
}
