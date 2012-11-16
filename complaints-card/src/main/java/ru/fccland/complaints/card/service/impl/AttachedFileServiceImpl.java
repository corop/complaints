package ru.fccland.complaints.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fccland.complaints.card.dao.AttachedFileDAO;
import ru.fccland.complaints.card.domain.AttachedFile;
import ru.fccland.complaints.card.service.AttachedFileService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AttachedFileServiceImpl implements AttachedFileService {
    @Autowired
    private AttachedFileDAO attachedFileDAO;

    @Transactional
    public AttachedFile get(Long id) {
        return  attachedFileDAO.get(id);
    }

    @Transactional
    public void add(AttachedFile attachedFile) {
        attachedFileDAO.add(attachedFile);
    }

    @Transactional
    public List<AttachedFile> list() {
        return attachedFileDAO.list();
    }

    @Transactional
    public void remove(Long id) {
        attachedFileDAO.remove(id);
    }

}
