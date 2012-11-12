package ru.fccland.complaints.card.dao;

import ru.fccland.complaints.card.domain.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 08.11.12
 * Time: 11:48
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryDAO {
    public void add(Category category);
    public List<Category> list();
    public void remove(Long id);
}
