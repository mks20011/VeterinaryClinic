package org.example.service;

import org.example.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> allOrder();
    void add(Order order);
    void delete(Order order);
    void edit(Order order);
    Order getById(int id);
}
