package org.example.dao;

import org.example.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> allOrder();
    void add(Order order);
    void delete(Order order);
    void edit(Order order);
    Order getById(int id);
}
