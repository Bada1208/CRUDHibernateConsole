package com.sysoiev.app.model;

import lombok.*;
import javax.persistence.*;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;

    public Customer(String name, String surname, Account account, Set<Specialty> specialtySet) {
    }
   /* @OneToMany(mappedBy = "customers", fetch = FetchType.LAZY)
    private Set<Specialty> customerSpecialties = new HashSet<>();*/
    /*@Column(name="account_id")
    private Account customerAccount;*/

}
