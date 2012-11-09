package ru.fccland.complaints.card.form;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 08.11.12
 * Time: 8:18
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="CMPL_CATEGORY")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="CMPL_SEQ_CATEGORY")
    @SequenceGenerator(name="CMPL_SEQ_CATEGORY", sequenceName="CMPL_SEQ_CATEGORY")
    @Column(name="CATEGORY_ID")
    private Long id;
    @Column(name="CATEGORY_NAME")
    private String name;

    public Category() {
    }

    public Category(Long id, String name) {
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
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
