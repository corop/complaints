package ru.fccland.complaints.card.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 08.11.12
 * Time: 8:23
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="CMPL_DOC_TYPE")
public class DocType  implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="CMPL_SEQ_DOC_TYPE")
    @SequenceGenerator(name="CMPL_SEQ_DOC_TYPE", sequenceName="CMPL_SEQ_DOC_TYPE")
    @Column(name="DOC_TYPE_ID")
    private Long id;
    @Column(name="DOC_TYPE_NAME")
    private String name;

    public DocType() {
    }

    public DocType(Long id, String name) {
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
        return "DocType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
