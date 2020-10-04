package com.sysoiev.app.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String surname;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Specialty> customerSpecialties = new HashSet<>();
    private Account customerAccount;

}
