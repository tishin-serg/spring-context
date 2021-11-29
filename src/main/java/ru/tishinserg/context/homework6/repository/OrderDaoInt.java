package ru.tishinserg.context.homework6.repository;

import ru.tishinserg.context.homework6.model.Order;

import java.util.List;

public interface OrderDaoInt {

    List<Order> findOrdersByCustomerId(Long customerId);

    List<Order> findOrdersByProductId(Long productId);

    List<Order> findAllOrders();

    Order findOrderById(Long orderId);
}
