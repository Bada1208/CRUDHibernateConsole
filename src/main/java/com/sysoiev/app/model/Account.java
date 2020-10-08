package com.sysoiev.app.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private Long id;
    @Column(name = "account_status")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    public Account() {
    }

    public Account(Long id, AccountStatus accountStatus) {
        this.id = id;
        this.accountStatus = accountStatus;
    }

    public Account(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }


    public Account(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Long getId() {
        return id;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    @Override
    public String toString() {
        return id + " " + accountStatus;
    }
}