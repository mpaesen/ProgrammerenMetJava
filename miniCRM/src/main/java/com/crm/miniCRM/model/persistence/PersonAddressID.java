package com.crm.miniCRM.model.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonAddressID implements  Serializable{
    @Column
    private Long person_ID;
    @Column
    private Long address_ID;


    public PersonAddressID(){}
    public PersonAddressID(Long person_ID, Long address_ID) {
        this.person_ID = person_ID;
        this.address_ID = address_ID;
    }

    public Long getPerson_ID() {
        return person_ID;
    }

    public void setPerson_ID(Long personID) {
        this.person_ID = personID;
    }

    public Long getAddress_ID() {
        return address_ID;
    }

    public void setAddress_ID(Long addressID) {
        this.address_ID = addressID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonAddressID that = (PersonAddressID) o;
        return person_ID.equals(that.person_ID) && address_ID.equals(that.address_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_ID, address_ID);
    }

    @Override
    public String toString() {
        return "PersonAddressID{" +
                "personID=" + person_ID +
                ", addressID=" + address_ID +
                '}';
    }
}
