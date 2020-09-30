package com.sysoiev.app.repository.impl;

import com.sysoiev.app.model.Account;
import com.sysoiev.app.repository.AccountRepository;

import java.util.ArrayList;

public class HibernateAccountRepository implements AccountRepository {
    @Override
    public Account save(Account data) {
        return null;
    }

    @Override
    public ArrayList<Account> getAll() {
        return null;
    }

    @Override
    public Account getById(Long aLong) {
        return null;
    }

    @Override
    public void update(Long aLong, Account data) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
