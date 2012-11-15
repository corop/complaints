package ru.fccland.complaints.card.dao;

import ru.fccland.complaints.card.domain.AttachedFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
public interface AttachedFileDAO {
    public AttachedFile get(Long id);
    public void add(AttachedFile attachedFile);
    public List<AttachedFile> list();
    public void remove(Long id);
}
