package ru.tishinserg.context.homework6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tishinserg.context.homework6.model.Customer;
import ru.tishinserg.context.homework6.model.Order;
import ru.tishinserg.context.homework6.model.Product;
import ru.tishinserg.context.homework6.repository.OrderDaoInt;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private OrderDaoInt orderDaoInt;

    @Autowired
    public void setOrderDaoInt(OrderDaoInt orderDaoInt) {
        this.orderDaoInt = orderDaoInt;
    }

    // правильно ли я понимаю, что этой логикой должен заниматься как раз сервис?
    public List<Product> findProductsByCustomerId(Long customerId) {
        return orderDaoInt.findOrdersByCustomerId(customerId).stream()
                .map(order -> order.getProduct())
                .collect(Collectors.toList());
    }

    public List<Customer> findCustomersByProductId(Long productId) {
        return orderDaoInt.findOrdersByProductId(productId).stream()
                .map(order -> order.getCustomer())
                .collect(Collectors.toList());
    }

    public List<Order> findAllOrders() {
        return orderDaoInt.findAllOrders();
    }

    // Не до конца понял 4ое задание. Смысл найти цену по заказу?
    public Integer findCostByOrderId(Long id) {
       return orderDaoInt.findOrderById(id).getProduct().getCost();
    }

}
