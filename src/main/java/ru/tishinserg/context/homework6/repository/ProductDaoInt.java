package ru.tishinserg.context.homework6.repository;

import ru.tishinserg.context.homework6.model.Product;

public interface ProductDaoInt {
    Product findProductById(Long id);
    // Integer findCostByProduct(Product product);
}
