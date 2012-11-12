package ru.fccland.complaints.card.service;

import ru.fccland.complaints.card.domain.Complaint;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */
public interface ComplaintService {
    public void add(Complaint complaint);
    public List<Complaint> list();
    public void remove(Long id);
}
