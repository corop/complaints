package ru.fccland.complaints.card.controller;

import ru.fccland.complaints.card.domain.Category;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 12.11.12
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name="categories")
public class CategoryList {

    private List<Category> data;

    @XmlElement(required = true)
    public List<Category> getData() {
        return data;
    }

    public void setData(List<Category> data) {
        this.data = data;
    }

}
