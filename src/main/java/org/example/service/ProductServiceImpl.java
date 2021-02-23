package org.example.service;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{


    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public List<Product> allProduct() {
        return productDao.allProduct();
    }

    @Override
    @Transactional
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Override
    @Transactional
    public void edit(Product product) {
        productDao.edit(product);
    }

    @Override
    @Transactional
    public Product getById(int id) {
        return productDao.getById(id);
    }
}
