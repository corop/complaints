package ru.fccland.complaints.card.service;

import ru.fccland.complaints.card.domain.ComplaintAuthor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
public interface ComplaintAuthorService {
    public void add(ComplaintAuthor complaintAuthor);
    public List<ComplaintAuthor> list();
    public void remove(Long id);
}
