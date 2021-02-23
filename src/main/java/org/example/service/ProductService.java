package org.example.service;

import org.example.model.Product;


import java.util.List;

public interface ProductService {
    List<Product> allProduct();
    void add(Product product);
    void delete(Product product);
    void edit(Product product);
    Product getById(int id);
}
