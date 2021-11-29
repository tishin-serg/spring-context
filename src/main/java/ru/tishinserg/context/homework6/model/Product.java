package ru.tishinserg.context.homework6.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products", schema = "shop")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tittle")
    private String tittle;

    @Column(name = "cost")
    private Integer cost;

    /*
    @ManyToMany
    @JoinTable(
            name = "customers_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;

     */

    @OneToMany(mappedBy = "product")
    private List<Order> orders;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /*
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
     */

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", cost=" + cost +
                '}';
    }
}
