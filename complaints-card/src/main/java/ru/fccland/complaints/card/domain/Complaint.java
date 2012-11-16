package ru.fccland.complaints.card.domain;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPLAINT_AUTHOR_ID", nullable = false)
    private ComplaintAuthor complaintAuthor;
    @Column(name="HTTP_SESSION_ID")
    private String httpSessionId;
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
    @Column(name="COMPLAINT_SENDED")
    private Long sended;
    @Column(name="COMPLAINT_APPEAL")
    @Lob
    private String appeal;

    public Complaint() {
    }

    public Complaint(Long id, Department department, Category category, ComplaintAuthor complaintAuthor, String httpSessionId, String govName, String firstName, String lastName, String thirdName, String company, String postIndex, String postAddress, String phone, String email, Date inserted, Long sended, String appeal) {
        this.id = id;
        this.department = department;
        this.category = category;
        this.complaintAuthor = complaintAuthor;
        this.httpSessionId = httpSessionId;
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
        this.sended = sended;
        this.appeal = appeal;
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

    public ComplaintAuthor getComplaintAuthor() {
        return complaintAuthor;
    }

    public void setComplaintAuthor(ComplaintAuthor complaintAuthor) {
        this.complaintAuthor = complaintAuthor;
    }

    public String getHttpSessionId() {
        return httpSessionId;
    }

    public void setHttpSessionId(String httpSessionId) {
        this.httpSessionId = httpSessionId;
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

    public Long getSended() {
        return sended;
    }

    public void setSended(Long sended) {
        this.sended = sended;
    }

    public String getAppeal() {
        return appeal;
    }

    public void setAppeal(String appeal) {
        this.appeal = appeal;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                 "\n, department=" + department +
                 "\n, category=" + category +
                 "\n, complaintAuthor=" + complaintAuthor +
                 "\n, httpSessionId='" + httpSessionId + '\'' +
                 "\n, govName='" + govName + '\'' +
                 "\n, firstName='" + firstName + '\'' +
                 "\n, lastName='" + lastName + '\'' +
                 "\n, thirdName='" + thirdName + '\'' +
                 "\n, company='" + company + '\'' +
                 "\n, postIndex='" + postIndex + '\'' +
                 "\n, postAddress='" + postAddress + '\'' +
                 "\n, phone='" + phone + '\'' +
                 "\n, email='" + email + '\'' +
                 "\n, inserted=" + inserted +
                 "\n, sended=" + sended +
                 "\n, appeal='" + appeal + '\'' +
                '}';
    }
}

