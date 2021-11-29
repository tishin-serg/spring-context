package ru.tishinserg.context.homework6.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.tishinserg.context.homework6.model.Customer;

@Component
public class CustomerDao implements CustomerDaoInt {

    private SessionFactoryUtils factory;

    public CustomerDao(SessionFactoryUtils factory) {
        this.factory = factory;
    }

    @Override
    public Customer findCustomerById(Long id) {
        Customer customer = null;
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            customer = session.get(Customer.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }
}
