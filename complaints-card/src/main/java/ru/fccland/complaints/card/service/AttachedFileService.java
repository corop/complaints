package ru.fccland.complaints.card.service;

import ru.fccland.complaints.card.form.AttachedFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 */
public interface AttachedFileService {
    public void add(AttachedFile attachedFile);
    public List<AttachedFile> list();
    public void remove(Long id);

}
