package com.sysoiev.app.repository.impl;

import com.sysoiev.app.model.Customer;
import com.sysoiev.app.repository.CustomerRepository;
import com.sysoiev.app.util.SessionUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class HibernateCustomerRepository implements CustomerRepository {
    private final SessionUtil sessionUtil = new SessionUtil();
    @Override
    public void save(Customer data) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.save(data);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Customer> getAll() {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        List<Customer> customerList = session.createQuery("FROM Customer ").list();
        sessionUtil.closeTransactionSession();
        return customerList;
    }

    @Override
    public Customer getById(Long id) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery("SELECT * FROM customers WHERE id = :id").addEntity(Customer.class);
        query.setParameter("id", id);
        Customer customer = (Customer) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return customer;
    }

    @Override
    public void update( Customer data) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.update(data);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void deleteById(Long id) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        Customer customer=new Customer();
        customer.setId(id);
        session.remove(customer);
        sessionUtil.closeTransactionSession();
    }
}
