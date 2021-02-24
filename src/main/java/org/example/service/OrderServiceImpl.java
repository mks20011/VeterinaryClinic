package org.example.service;

import org.example.dao.OrderDao;
import org.example.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private OrderDao orderDao;
@Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    @Transactional
    public List<Order> allOrder() {
        return orderDao.allOrder();
    }

    @Override
    @Transactional
    public void add(Order order) {
        orderDao.add(order);
    }

    @Override
    @Transactional
    public void delete(Order order) {
        orderDao.delete(order);
    }

    @Override
    @Transactional
    public void edit(Order order) {
        orderDao.edit(order);
    }

    @Override
    @Transactional
    public Order getById(int id) {
        return orderDao.getById(id);
    }
}
