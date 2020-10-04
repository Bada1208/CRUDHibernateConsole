package com.sysoiev.app.model;

import lombok.*;
import javax.persistence.Entity;
import org.hibernate.annotations.Table;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "specialty")
    private String specialty;
}
