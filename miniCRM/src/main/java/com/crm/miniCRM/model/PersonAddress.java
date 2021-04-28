package com.crm.miniCRM.model;

import com.crm.miniCRM.model.persistence.PersonAddressID;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="person_address")
public class PersonAddress implements Serializable {
    @EmbeddedId
    private PersonAddressID Id;

    private String email;
    private String phone;
    private String mobile;
    private char    type;



    public PersonAddress(){}
    public PersonAddress(PersonAddressID Id, String email, String phone, String mobile, char type) {
        this.Id = Id;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.type = type;
    }

    public PersonAddressID getId() {
        return Id;
    }

    public void setId(PersonAddressID personAddressID) {
        this.Id = personAddressID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PersonAddress{" +
                "personAddressID=" + Id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type=" + type +
                '}';
    }
}
