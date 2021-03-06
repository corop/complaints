package ru.fccland.complaints.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.DocTypeDAO;
import ru.fccland.complaints.card.domain.DocType;
import ru.fccland.complaints.card.service.DocTypeService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DocTypeServiceImpl implements DocTypeService {
    @Autowired
    private DocTypeDAO docTypeDAO;

    @Transactional
    public DocType get(Long id) {
        return docTypeDAO.get(id);
    }

    @Transactional
    public void add(DocType docType) {
        docTypeDAO.add(docType);
    }

    @Transactional
    public List<DocType> list() {
        return docTypeDAO.list();
    }

    @Transactional
    public void remove(Long id) {
        docTypeDAO.remove(id);
    }

}
