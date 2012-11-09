package ru.fccland.complaints.card.dao;

import ru.fccland.complaints.card.form.DocType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 5:15
 * To change this template use File | Settings | File Templates.
 */

public interface DocTypeDAO  {
    public void add(DocType docType);
    public List<DocType> list();
    public void remove(Long id);
}