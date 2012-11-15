package ru.fccland.complaints.card.dao;

import ru.fccland.complaints.card.domain.ComplaintAuthor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 18:40
 * To change this template use File | Settings | File Templates.
 */
public interface ComplaintAuthorDAO {
    public ComplaintAuthor get(Long id);
    public void add(ComplaintAuthor complaintAuthor);
    public List<ComplaintAuthor> list();
    public void remove(Long id);
}
