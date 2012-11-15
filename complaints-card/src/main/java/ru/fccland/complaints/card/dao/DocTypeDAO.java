package ru.fccland.complaints.card.dao;

import ru.fccland.complaints.card.domain.DocType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 5:15
 * To change this template use File | Settings | File Templates.
 */

public interface DocTypeDAO  {
    public DocType get(Long id);
    public void add(DocType docType);
    public List<DocType> list();
    public void remove(Long id);
}