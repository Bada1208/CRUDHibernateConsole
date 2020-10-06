package com.sysoiev.app.repository.impl;

import com.sysoiev.app.model.Customer;
import com.sysoiev.app.repository.CustomerRepository;

import java.util.List;

public class HibernateCustomerRepository implements CustomerRepository {
    @Override
    public void save(Customer data) {

    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getById(Long aLong) {
        return null;
    }

    @Override
    public void update( Customer data) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
