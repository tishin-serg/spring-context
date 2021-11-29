package ru.tishinserg.context.homework6.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.tishinserg.context.homework6.model.Product;

@Component
public class ProductDao implements ProductDaoInt{

    private SessionFactoryUtils factory;

    public ProductDao(SessionFactoryUtils factory) {
        this.factory = factory;
    }

    @Override
    public Product findProductById(Long id) {
        Product product = null;
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }


    /* А можно делать так? При условии существования такого метода в интерфейсе?

    @Override
    public Integer findCostById(Long id) {
        Integer cost = null;
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            cost = findProductById(id).getCost();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cost;
    }

     */

}
