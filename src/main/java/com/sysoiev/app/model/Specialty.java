package com.sysoiev.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Specialty {
    private Long id;
    private String specialty;

}
