package com.sysoiev.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Entity;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private Long id;
    private String name;
    private String surname;
    private Set<Specialty> customerSpecialties = new HashSet<>();
    private Account customerAccount;

}
