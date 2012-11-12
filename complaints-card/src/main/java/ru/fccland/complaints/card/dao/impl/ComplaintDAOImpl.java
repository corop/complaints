package ru.fccland.complaints.card.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.ComplaintDAO;
import ru.fccland.complaints.card.domain.Complaint;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ComplaintDAOImpl implements ComplaintDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void add(Complaint complaint) {
        sessionFactory.getCurrentSession().save(complaint);
    }

    @Transactional
    @Override
    public List<Complaint> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM Complaint").list();
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Complaint complaint  = (Complaint) sessionFactory.getCurrentSession().load(
                Complaint.class, id);
        if (null != complaint) {
            sessionFactory.getCurrentSession().delete(complaint);
        }
    }
}
