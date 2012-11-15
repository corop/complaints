package ru.fccland.complaints.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.ComplaintDAO;
import ru.fccland.complaints.card.domain.Complaint;
import ru.fccland.complaints.card.service.ComplaintService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 20:18
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintDAO complaintDAO;

    @Transactional
    @Override
    public Complaint get(Long id) {
        return complaintDAO.get(id);
    }

    @Transactional
    @Override
    public void add(Complaint complaint) {
        complaintDAO.add(complaint);
    }

    @Transactional
    @Override
    public List<Complaint> list() {
        return complaintDAO.list();
    }

    @Transactional
    @Override
    public void remove(Long id) {
        complaintDAO.remove(id);
    }
}
