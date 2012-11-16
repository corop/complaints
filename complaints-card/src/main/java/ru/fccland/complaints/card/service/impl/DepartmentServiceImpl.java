package ru.fccland.complaints.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.DepartmentDAO;
import ru.fccland.complaints.card.domain.Department;
import ru.fccland.complaints.card.service.DepartmentService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 08.11.12
 * Time: 9:11
 * To change this template use File | Settings | File Templates.
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDAO departmentDAO;

    @Transactional
    public Department get(Long id) {
        return departmentDAO.get(id);
    }

    @Transactional
    public void add(Department department) {
        departmentDAO.add(department);
    }

    @Transactional
    public List<Department> list() {
        return departmentDAO.list();
    }

    @Transactional
    public void remove(Long id) {
        departmentDAO.remove(id);
    }
}
