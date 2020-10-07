package com.sysoiev.app.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private Long id;
    @Column(name = "specialty")
    private String specialty;

    public Specialty() {
    }

    public Specialty(Long id, String specialty) {
        this.id = id;
        this.specialty = specialty;
    }

    public Specialty(Long id) {
        this.id = id;
    }

    public Specialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialty specialties = (Specialty) o;

        if (!Objects.equals(id, specialties.id)) return false;
        return Objects.equals(specialty, specialties.specialty);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return id + " " + specialty;
    }
}
