package ru.fccland.complaints.card.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.AttachedFileDAO;
import ru.fccland.complaints.card.form.AttachedFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AttachedFileDAOImpl implements AttachedFileDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void add(AttachedFile attachedFile) {
        sessionFactory.getCurrentSession().save(attachedFile);
    }

    @Transactional
    @Override
    public List<AttachedFile> list() {
        return sessionFactory.getCurrentSession().createQuery("from AttachedFile").list();
    }

    @Transactional
    @Override
    public void remove(Long id) {
        AttachedFile attachedFile = (AttachedFile) sessionFactory.getCurrentSession().load(
                AttachedFile.class, id);
        if (null != attachedFile) {
            sessionFactory.getCurrentSession().delete(attachedFile);
        }
    }


}