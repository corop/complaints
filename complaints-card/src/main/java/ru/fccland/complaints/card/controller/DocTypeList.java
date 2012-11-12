package ru.fccland.complaints.card.controller;

import ru.fccland.complaints.card.domain.DocType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 12.11.12
 * Time: 17:52
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name="doctypes")
public class DocTypeList {
    private List<DocType> data;

    @XmlElement(required = true)
    public List<DocType> getData() {
        return data;
    }

    public void setData(List<DocType> data) {
        this.data = data;
    }

}
