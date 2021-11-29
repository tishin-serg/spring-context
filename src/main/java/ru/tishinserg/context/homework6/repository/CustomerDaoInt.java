package ru.tishinserg.context.homework6.repository;

import ru.tishinserg.context.homework6.model.Customer;
import ru.tishinserg.context.homework6.model.Product;

import java.util.List;

public interface CustomerDaoInt {
    Customer findCustomerById (Long id);
    // List<Product> findProductsByCustomerId(Long id);
}
