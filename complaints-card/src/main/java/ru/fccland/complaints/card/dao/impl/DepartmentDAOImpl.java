package ru.fccland.complaints.card.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.DepartmentDAO;
import ru.fccland.complaints.card.form.Department;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 08.11.12
 * Time: 9:04
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void add(Department department) {
        sessionFactory.getCurrentSession().save(department);
    }

    @Transactional
    @Override
    public List<Department> list() {
        return sessionFactory.getCurrentSession().createQuery("from Department").list();
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Department department = (Department) sessionFactory.getCurrentSession().load(
                Department.class, id);
        if (null != department) {
            sessionFactory.getCurrentSession().delete(department);
        }
    }
}
