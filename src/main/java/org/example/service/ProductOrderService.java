package org.example.service;

import org.example.model.ProductOrder;

import java.util.List;

public interface ProductOrderService {
    List<ProductOrder> allProductOrder();
    void add(ProductOrder productOrder);
    void delete(ProductOrder productOrder);
    void edit(ProductOrder productOrder);
    ProductOrder getById(int id);
}
