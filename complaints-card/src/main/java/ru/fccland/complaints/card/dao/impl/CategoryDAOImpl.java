package ru.fccland.complaints.card.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.CategoryDAO;
import ru.fccland.complaints.card.domain.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 08.11.12
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Category get(Long id) {
        return (Category) sessionFactory.getCurrentSession().load(Category.class, id);
    }

    @Transactional
    @Override
    public void add(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    @Transactional
    @Override
    public List<Category> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM Category").list();
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Category category = get(id);
        if (null != category) {
            sessionFactory.getCurrentSession().getTransaction().begin();
            sessionFactory.getCurrentSession().delete(category);
            sessionFactory.getCurrentSession().getTransaction().commit();
        }
    }
}
