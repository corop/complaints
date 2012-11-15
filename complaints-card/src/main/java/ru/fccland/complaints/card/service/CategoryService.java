package ru.fccland.complaints.card.service;

import ru.fccland.complaints.card.domain.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 18:52
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryService {
    public Category get(Long id);
    public void add(Category category);
    public List<Category> list();
    public void remove(Long id);
}
