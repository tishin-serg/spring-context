package ru.tishinserg.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.tishinserg.context");

        Cart cart = context.getBean(Cart.class);
        Scanner scanner = new Scanner(System.in);
        Long id = scanner.nextLong();
        cart.addToCartById(id);
        cart.show();

        scanner.close();
        context.close();
    }
}
