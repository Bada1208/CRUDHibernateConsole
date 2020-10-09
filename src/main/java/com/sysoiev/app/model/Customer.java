package com.sysoiev.app.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "specialty_id")
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Specialty> customerSpecialties = new HashSet<>();
    @Column(name = "account_id")
    @OneToOne(cascade = {CascadeType.PERSIST})
    private Account customerAccount;


    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Customer(Long id, String name, String surname, Account account, Set<Specialty> specialties) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.customerAccount = account;
        this.customerSpecialties = specialties;
    }

    public Customer(Long id, String name, String surname, Account account) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.customerAccount = account;
    }

    public Customer(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerSpecialties(Specialty customerSpecialty) {
        this.customerSpecialties.add(customerSpecialty);
    }

    public void setCustomerSpecialtiesSet(Set<Specialty> customerSpecialtiesSet) {
        this.customerSpecialties = customerSpecialtiesSet;
    }

    public void setCustomerAccount(Account customerAccount) {
        this.customerAccount = customerAccount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public Long getId() {
        return id;
    }

    public Set<Specialty> getCustomerSpecialtiesSet() {
        return customerSpecialties;
    }

    public Account getCustomerAccount() {
        return customerAccount;
    }

    public String getName() {
        return name;
    }

    public String getSpecialties() {
        String specialtyString = "";
        for (Specialty s : customerSpecialties) {
            specialtyString += "{" + s.getId() + "}";
        }
        return specialtyString;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + customerAccount.getId() + " " + getSpecialties();
    }

}
