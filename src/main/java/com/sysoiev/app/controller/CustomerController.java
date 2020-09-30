package com.sysoiev.app.controller;


import com.sysoiev.app.model.Customer;
import com.sysoiev.app.repository.CustomerRepository;
import com.sysoiev.app.repository.impl.HibernateCustomerRepository;

import java.util.List;

public class CustomerController {
    private CustomerRepository customerRepository = new HibernateCustomerRepository();

    public List<Customer> printAll() {
        return customerRepository.getAll();
    }

    public void saveCustomer(Customer newCustomer) {
        customerRepository.save(newCustomer);
    }

    public void deleteCustomer(Long index) {
        customerRepository.deleteById(index);
    }

    public void updateCustomer(Long id, Customer updateCustomer) {
        customerRepository.update(id, updateCustomer);
    }

    public Customer getValueByIndex(Long index) {
        return customerRepository.getById(index);
    }
}
