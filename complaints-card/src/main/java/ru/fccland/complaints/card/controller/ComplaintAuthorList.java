package ru.fccland.complaints.card.controller;

import ru.fccland.complaints.card.domain.ComplaintAuthor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 12.11.12
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name="authors")
public class ComplaintAuthorList {
    private List<ComplaintAuthor> data;

    @XmlElement(required = true)
    public List<ComplaintAuthor> getData() {
        return data;
    }

    public void setData(List<ComplaintAuthor> data) {
        this.data = data;
    }

}
