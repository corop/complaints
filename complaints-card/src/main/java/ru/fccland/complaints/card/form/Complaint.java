package ru.fccland.complaints.card.form;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 08.11.12
 * Time: 8:50
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="CMPL_COMPLAINT")
public class Complaint  implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="CMPL_SEQ_COMPLAINT")
    @SequenceGenerator(name="CMPL_SEQ_COMPLAINT", sequenceName="CMPL_SEQ_COMPLAINT")
    @Column(name="COMPLAINT_ID")
    private Long id;
    @ManyToOne
    private Department department;
    @ManyToOne
    private Category category;
    @Column(name="COMPLAINT_GOV_NAME")
    private String govName;
    @Column(name="COMPLAINT_FNAME")
    private String firstName;
    @Column(name="COMPLAINT_LNAME")
    private String lastName;
    @Column(name="COMPLAINT_TNAME")
    private String thirdName;
    @Column(name="COMPLAINT_COMPANY")
    private String company;
    @Column(name="COMPLAINT_POST_INDEX")
    private String postIndex;
    @Column(name="COMPLAINT_POST_ADDRESS")
    private String postAddress;
    @Column(name="COMPLAINT_PHONE")
    private String phone;
    @Column(name="COMPLAINT_EMAIL")
    private String email;
    @Column(name="COMPLAINT_INSERTED")
    private Date inserted;

    public Complaint() {
    }

    public Complaint(Long id, Department department, Category category, String govName, String firstName, String lastName, String thirdName,
                     String company, String postIndex, String postAddress, String phone, String email, Date inserted) {
        this.id = id;
        this.department = department;
        this.category = category;
        this.govName = govName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.thirdName = thirdName;
        this.company = company;
        this.postIndex = postIndex;
        this.postAddress = postAddress;
        this.phone = phone;
        this.email = email;
        this.inserted = inserted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getGovName() {
        return govName;
    }

    public void setGovName(String govName) {
        this.govName = govName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getInserted() {
        return inserted;
    }

    public void setInserted(Date inserted) {
        this.inserted = inserted;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", department=" + department +
                ", category=" + category +
                ", govName='" + govName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", company='" + company + '\'' +
                ", postIndex='" + postIndex + '\'' +
                ", postAddress='" + postAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", inserted=" + inserted +
                '}';
    }
}

