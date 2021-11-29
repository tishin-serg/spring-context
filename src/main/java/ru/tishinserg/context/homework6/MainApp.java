package ru.tishinserg.context.homework6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.tishinserg.context.homework6.service.OrderService;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.tishinserg.context.homework6" +
                ".repository", "ru.tishinserg.context.homework6.service");

        OrderService orderService = context.getBean(OrderService.class);
        orderService.findProductsByCustomerId(2L).forEach(System.out::println);
        orderService.findCustomersByProductId(3L).forEach(System.out::println);
        System.out.println(orderService.findCostByOrderId(1L));
        context.close();
    }
}
