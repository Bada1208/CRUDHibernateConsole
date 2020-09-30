package com.sysoiev.app.repository.impl;

import com.sysoiev.app.model.Customer;
import com.sysoiev.app.repository.CustomerRepository;

import java.util.ArrayList;

public class HibernateCustomerRepository implements CustomerRepository {
    @Override
    public Customer save(Customer data) {
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getById(Long aLong) {
        return null;
    }

    @Override
    public void update(Long aLong, Customer data) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
