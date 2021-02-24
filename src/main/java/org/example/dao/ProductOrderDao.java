package org.example.dao;

import org.example.model.ProductOrder;

import java.util.List;

public interface ProductOrderDao {
    List<ProductOrder> allProductOrder();
    void add(ProductOrder productOrder);
    void delete(ProductOrder productOrder);
    void edit(ProductOrder productOrder);
    ProductOrder getById(int id);
}
