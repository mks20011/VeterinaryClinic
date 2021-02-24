package org.example.service;

import org.example.dao.ProductOrderDao;
import org.example.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    private ProductOrderDao productOrderDao;

    @Autowired
    public void setProductOrderDao(ProductOrderDao productOrderDao) {
        this.productOrderDao = productOrderDao;
    }

    @Override
    public List<ProductOrder> allProductOrder() {
        return productOrderDao.allProductOrder();
    }

    @Override
    public void add(ProductOrder productOrder) {
        productOrderDao.add(productOrder);
    }

    @Override
    public void delete(ProductOrder productOrder) {
        productOrderDao.delete(productOrder);
    }

    @Override
    public void edit(ProductOrder productOrder) {
        productOrderDao.edit(productOrder);
    }

    @Override
    public ProductOrder getById(int id) {
        return productOrderDao.getById(id);
    }
}
