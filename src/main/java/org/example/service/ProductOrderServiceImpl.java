package org.example.service;

import org.example.dao.ProductOrderDao;
import org.example.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void add(ProductOrder productOrder) {
        productOrderDao.add(productOrder);
    }

    @Override
    @Transactional
    public void delete(ProductOrder productOrder) {
        productOrderDao.delete(productOrder);
    }

    @Override
    @Transactional
    public void edit(ProductOrder productOrder) {
        productOrderDao.edit(productOrder);
    }

    @Override
    @Transactional
    public ProductOrder getById(int id) {
        return productOrderDao.getById(id);
    }
}
