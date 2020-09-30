package com.sysoiev.app.controller;

import com.sysoiev.app.model.Specialty;
import com.sysoiev.app.repository.SpecialtyRepository;
import com.sysoiev.app.repository.impl.HibernateSpecialtyRepository;

import java.util.List;

public class SpecialtyController {
   private SpecialtyRepository specialtyRepository = new HibernateSpecialtyRepository();


    public List<Specialty> printAll() {
        return specialtyRepository.getAll();
    }

    public void saveSpecialty(Specialty newSpecialty) {
        specialtyRepository.save(newSpecialty);
    }

    public void deleteSpecialty(Long index) {
        specialtyRepository.deleteById(index);
    }

    public void updateSpecialty(Long id, Specialty updateSpecialty) {
        specialtyRepository.update(id, updateSpecialty);

    }

    public Specialty getValueByIndex(Long index) {
        return specialtyRepository.getById(index);
    }
}
