package ru.tishinserg.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")

public class Cart {
    private List<Product> cart;
    private ProductRepository productRepository;

    public Cart(List<Product> cart) {
        this.cart = cart;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addToCartById(Long id) {
        Product product = productRepository.findById(id);
        if (cart.add(product)) System.out.println(product.getTittle() + " добавили в корзину");
    }

    public void removeFromCartById(Long id) {
        Product product = productRepository.findById(id);
        if (!cart.remove(product)) {
            System.out.println("Товара " + product.getTittle() + " нет в корзине");
        } else {
            System.out.println("Товар " + product.getTittle() + " удален из корзины");
        } ;
    }

    public void show() {
        System.out.println("Содержимое корзины: ");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).getTittle());
        }
    }
}
