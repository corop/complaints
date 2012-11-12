package ru.fccland.complaints.card.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 08.11.12
 * Time: 7:51
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name="department")
@Entity
@Table(name="CMPL_DEPARTMENT")
public class Department  implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="CMPL_SEQ_DEPARTMENT")
    @SequenceGenerator(name="CMPL_SEQ_DEPARTMENT", sequenceName="CMPL_SEQ_DEPARTMENT")
    @Column(name="DEPARTMENT_ID")
    private Long id;
    @Column(name="DEPARTMENT_CODE")
    private String code;
    @Column(name="DEPARTMENT_NAME")
    private String name;
    @Column(name="DEPARTMENT_EMAIL")
    private String email;

    public Department() {
    }

    public Department(Long id, String code, String name, String email) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
