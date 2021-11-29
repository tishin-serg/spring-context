package ru.tishinserg.context.homework6.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.tishinserg.context.homework6.model.Order;

import java.util.List;

@Component
public class OrderDao implements OrderDaoInt {
    private SessionFactoryUtils factory;

    public OrderDao(SessionFactoryUtils factory) {
        this.factory = factory;
    }

    // не уверен в правильности этого подхода, но ничего другого не смог придумать
    @Override
    public List<Order> findOrdersByCustomerId(Long customerId) {
        List<Order> orderList = null;
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            orderList = session.createQuery("SELECT order FROM Order order WHERE order.customer.id = :customerId", Order.class)
                    .setParameter("customerId", customerId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> findOrdersByProductId(Long productId) {
        List<Order> orderList = null;
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            orderList = session.createQuery("SELECT order FROM Order order WHERE order.product.id = :productId", Order.class)
                    .setParameter("productId", productId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order> orderList = null;
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            orderList = session.createQuery("SELECT order FROM Order order", Order.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Order findOrderById(Long orderId) {
        Order order = null;
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            order = session.get(Order.class, orderId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }




    /*
    @Override
    public List<Product> findProductsByCustomerId(Long customerId) {
        List<Product> productList = null;
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Order> orders = session.createQuery("SELECT order FROM Order order WHERE customer_id = :customerId", Order.class)
                    .setParameter("id", customerId)
                    .getResultList();
            productList = orders.stream().map(order -> order.getProduct()).collect(Collectors.toList());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Customer> findCustomersByProductId(Long productId) {
        List<Customer> customerList = null;
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Order> orders = session.createQuery("SELECT order FROM Order order WHERE product_id = :productId", Order.class)
                    .setParameter("id", productId)
                    .getResultList();
            customerList = orders.stream().map(order -> order.getCustomer()).collect(Collectors.toList());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

     */


}
