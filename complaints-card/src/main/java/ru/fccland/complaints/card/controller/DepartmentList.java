package ru.fccland.complaints.card.controller;

import ru.fccland.complaints.card.domain.Department;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 12.11.12
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name="departments")
public class DepartmentList {

    private List<Department> data;

    @XmlElement(required = true)
    public List<Department> getData() {
        return data;
    }

    public void setData(List<Department> data) {
        this.data = data;
    }

}
