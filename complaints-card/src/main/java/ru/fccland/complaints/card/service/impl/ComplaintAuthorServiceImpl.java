package ru.fccland.complaints.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.ComplaintAuthorDAO;
import ru.fccland.complaints.card.domain.ComplaintAuthor;
import ru.fccland.complaints.card.service.ComplaintAuthorService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 20:01
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ComplaintAuthorServiceImpl implements ComplaintAuthorService {
    @Autowired
    private ComplaintAuthorDAO complaintAuthorDAO;

    @Transactional
    @Override
    public void add(ComplaintAuthor complaintAuthor) {
        complaintAuthorDAO.add(complaintAuthor);
    }

    @Transactional
    @Override
    public List<ComplaintAuthor> list() {
        return complaintAuthorDAO.list();
    }

    @Transactional
    @Override
    public void remove(Long id) {
        complaintAuthorDAO.remove(id);
    }

}
