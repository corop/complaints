package ru.fccland.complaints.card.dao;

import ru.fccland.complaints.card.form.Complaint;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 18:56
 * To change this template use File | Settings | File Templates.
 */
public interface ComplaintDAO {
    public void add(Complaint complaint);
    public List<Complaint> list();
    public void remove(Long id);
}
