package ru.tishinserg.context.homework6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tishinserg.context.homework6.repository.ProductDaoInt;

@Service
public class ProductService {

    private ProductDaoInt productDaoInt;

    @Autowired
    public void setProductDaoInt(ProductDaoInt productDaoInt) {
        this.productDaoInt = productDaoInt;
    }
}
