package ru.tishinserg.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<Product>(Arrays.asList(
                new Product(1L, "Milk", 10),
                new Product(2L, "Bread", 20),
                new Product(3L, "Butter", 15),
                new Product(4L, "Meat", 100),
                new Product(5L, "Apple", 20)));

    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId().
                equals(id)).
                findFirst().
                orElseThrow(() -> new RuntimeException("Товара с id=" + id + " не существует"));
    }

    public List<Product> getProducts() {
        return products;
    }
}
