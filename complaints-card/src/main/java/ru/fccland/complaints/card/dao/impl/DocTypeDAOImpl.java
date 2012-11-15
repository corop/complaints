package ru.fccland.complaints.card.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.DocTypeDAO;
import ru.fccland.complaints.card.domain.DocType;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 5:21
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DocTypeDAOImpl implements DocTypeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public DocType get(Long id) {
        return (DocType) sessionFactory.getCurrentSession().load(
                DocType.class, id);
    }

    @Transactional
    @Override
    public void add(DocType docType) {
        sessionFactory.getCurrentSession().save(docType);
    }

    @Transactional
    @Override
    public List<DocType> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM DocType").list();
    }

    @Transactional
    @Override
    public void remove(Long id) {
        DocType docType = get(id);
        if (null != docType) {
            sessionFactory.getCurrentSession().delete(docType);
        }
    }

}
