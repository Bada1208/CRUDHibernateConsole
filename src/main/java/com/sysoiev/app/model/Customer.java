package com.sysoiev.app.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
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
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private Set<Specialty> customerSpecialties = new HashSet<>();
    @JoinColumn(name = "account_id")
    @OneToOne(cascade = {CascadeType.ALL})
    private Account customerAccount;


    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Customer(String name, String surname, Account account, Set<Specialty> specialties) {
        this.name = name;
        this.surname = surname;
        this.customerAccount = account;
        this.customerSpecialties = specialties;
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
            specialtyString += "{" + s.getId() + ", " + s.getSpecialty() + "}";
        }
        return specialtyString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!Objects.equals(id, customer.id)) return false;
        if (!Objects.equals(name, customer.name)) return false;
        if (!Objects.equals(surname, customer.surname)) return false;
        return Objects.equals(customerAccount, customer.customerAccount);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (customerAccount != null ? customerAccount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + customerAccount.getId() + " " + getSpecialties();
    }

}
