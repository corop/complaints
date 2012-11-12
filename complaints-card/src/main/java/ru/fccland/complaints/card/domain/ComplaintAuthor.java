package ru.fccland.complaints.card.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 09.11.12
 * Time: 18:37
 * To change this template use File | Settings | File Templates.
 */

/*
CREATE TABLE CMPL_COMPLAINT_AUTHOR
(
    COMPLAINT_AUTHOR_ID int PRIMARY KEY NOT NULL,
    COMPLAINT_AUTHOR_NAME varchar2(64) NOT NULL
)
 */

@Entity
@Table(name="CMPL_COMPLAINT_AUTHOR")
public class ComplaintAuthor implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="CMPL_SEQ_COMPLAINT_AUTHOR")
    @SequenceGenerator(name="CMPL_SEQ_COMPLAINT_AUTHOR", sequenceName="CMPL_SEQ_COMPLAINT_AUTHOR")
    @Column(name="COMPLAINT_AUTHOR_ID")
    private Long id;
    @Column(name="COMPLAINT_AUTHOR_NAME")
    private String name;

    public ComplaintAuthor() {
    }

    public ComplaintAuthor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ComplaintAuthor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
