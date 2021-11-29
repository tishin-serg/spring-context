package ru.tishinserg.context.homework6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tishinserg.context.homework6.repository.CustomerDaoInt;

@Service
public class CustomerService {

    private CustomerDaoInt customerDaoInt;

    @Autowired
    public void setCustomerDaoInt(CustomerDaoInt customerDaoInt) {
        this.customerDaoInt = customerDaoInt;
    }


}
