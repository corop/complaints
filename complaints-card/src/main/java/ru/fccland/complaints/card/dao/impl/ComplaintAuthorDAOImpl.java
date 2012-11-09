package ru.fccland.complaints.card.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.ComplaintAuthorDAO;
import ru.fccland.complaints.card.form.ComplaintAuthor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ComplaintAuthorDAOImpl implements ComplaintAuthorDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void add(ComplaintAuthor complaintAuthor) {
        sessionFactory.getCurrentSession().save(complaintAuthor);
    }

    @Transactional
    @Override
    public List<ComplaintAuthor> list() {
        return sessionFactory.getCurrentSession().createQuery("from ComplaintAuthor").list();
    }

    @Transactional
    @Override
    public void remove(Long id) {
        ComplaintAuthor complaintAuthor  = (ComplaintAuthor) sessionFactory.getCurrentSession().load(
                ComplaintAuthor.class, id);
        if (null != complaintAuthor) {
            sessionFactory.getCurrentSession().delete(complaintAuthor);
        }
    }
}
