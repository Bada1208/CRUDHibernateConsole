package com.sysoiev.app.repository.impl;

import com.sysoiev.app.model.Specialty;
import com.sysoiev.app.repository.SpecialtyRepository;
import com.sysoiev.app.util.SessionUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class HibernateSpecialtyRepository implements SpecialtyRepository {
    private final SessionUtil sessionUtil = new SessionUtil();

    @Override
    public void save(Specialty data) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.save(data);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Specialty> getAll() {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        List<Specialty> specialtyList = session.createQuery("FROM Specialty ").list();
        sessionUtil.closeTransactionSession();
        return specialtyList;
    }

    @Override
    public Specialty getById(Long id) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery("SELECT * FROM specialties WHERE id = :id").addEntity(Specialty.class);
        query.setParameter("id", id);
        Specialty specialty = (Specialty) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return specialty;
    }

    @Override
    public void update(Specialty data) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.update(data);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void deleteById(Long id) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        Specialty specialty = new Specialty();
        specialty.setId(id);
        session.remove(specialty);
        sessionUtil.closeTransactionSession();
    }
}
