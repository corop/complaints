package ru.fccland.complaints.card.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: asergeev
 * Date: 15.11.12
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
public class Message implements Serializable {

    private static final long serialVersionUID = -4093981756240899937L;

    private String department;
    private String dep_name;
    private String who;
    private String lastname;
    private String firstname;
    private String thirdname;
    private String entitlement;
    private String post_index;
    private String post_address;
    private String phone;
    private String email;    
    private String category;
    private String appeal;

    public Message() {
        super();
    }

    public Message(String department, String dep_name, String who, String lastname, String firstname, String thirdname, String entitlement, String post_index, String post_address, String phone, String email, String category, String appeal) {
        this.department = department;
        this.dep_name = dep_name;
        this.who = who;
        this.lastname = lastname;
        this.firstname = firstname;
        this.thirdname = thirdname;
        this.entitlement = entitlement;
        this.post_index = post_index;
        this.post_address = post_address;
        this.phone = phone;
        this.email = email;
        this.category = category;
        this.appeal = appeal;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public String getEntitlement() {
        return entitlement;
    }

    public void setEntitlement(String entitlement) {
        this.entitlement = entitlement;
    }

    public String getPost_index() {
        return post_index;
    }

    public void setPost_index(String post_index) {
        this.post_index = post_index;
    }

    public String getPost_address() {
        return post_address;
    }

    public void setPost_address(String post_address) {
        this.post_address = post_address;
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

    public String getAppeal() {
        return appeal;
    }

    public void setAppeal(String appeal) {
        this.appeal = appeal;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Message{" +
                "department='" + department + '\'' +
                ", dep_name='" + dep_name + '\'' +
                ", who='" + who + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", thirdname='" + thirdname + '\'' +
                ", entitlement='" + entitlement + '\'' +
                ", post_index='" + post_index + '\'' +
                ", post_address='" + post_address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", category='" + category + '\'' +
                ", appeal='" + appeal + '\'' +
                '}';
    }
}
