package com.sysoiev.app.repository.impl;

import com.sysoiev.app.model.Account;
import com.sysoiev.app.model.Specialty;
import com.sysoiev.app.repository.AccountRepository;
import com.sysoiev.app.util.SessionUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class HibernateAccountRepository implements AccountRepository {
    private final SessionUtil sessionUtil = new SessionUtil();

    @Override
    public void save(Account data) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.save(data);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Account> getAll() {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        List<Account> accountList = session.createQuery("FROM Account ").list();
        sessionUtil.closeTransactionSession();
        return accountList;
    }

    @Override
    public Account getById(Long id) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery("SELECT * FROM accounts WHERE id = :id").addEntity(Account.class);
        query.setParameter("id", id);
        Account account = (Account) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return account;
    }

    @Override
    public void update(Account data) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.update(data);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void deleteById(Long id) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        Account account = new Account();
        account.setId(id);
        session.remove(account);
        sessionUtil.closeTransactionSession();
    }
}
