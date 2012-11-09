package ru.fccland.complaints.card.service;

import ru.fccland.complaints.card.form.Department;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 08.11.12
 * Time: 9:09
 * To change this template use File | Settings | File Templates.
 */
public interface DepartmentService {
    public void add(Department department);
    public List<Department> list();
    public void remove(Long id);
}
