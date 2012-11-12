package ru.fccland.complaints.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.CategoryDAO;
import ru.fccland.complaints.card.domain.Category;
import ru.fccland.complaints.card.service.CategoryService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 18:53
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional
    @Override
    public void add(Category category) {
        categoryDAO.add(category);
    }

    @Transactional
    @Override
    public List<Category> list() {
        return categoryDAO.list();
    }

    @Transactional
    @Override
    public void remove(Long id) {
        categoryDAO.remove(id);
    }
}
