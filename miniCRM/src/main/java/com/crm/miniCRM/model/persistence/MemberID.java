package com.crm.miniCRM.model.persistence;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MemberID implements Serializable {

    @Column
    private Long community_ID;
    @Column
    private Long person_ID;

    public MemberID(){}
    public MemberID(Long person_ID, Long community_ID) {
        this.person_ID = person_ID;
        this.community_ID = community_ID;
    }

    public Long getPerson_ID() {
        return person_ID;
    }

    public void setPerson_ID(Long person_ID) {
        this.person_ID = person_ID;
    }

    public Long getCommunity_ID() {
        return community_ID;
    }

    public void setCommunity_ID(Long community_ID) {
        this.community_ID = community_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberID memberID = (MemberID) o;
        return person_ID.equals(memberID.person_ID) && community_ID.equals(memberID.community_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_ID, community_ID);
    }

    @Override
    public String toString() {
        return "MemberID{" +
                "person_ID=" + person_ID +
                ", community_ID=" + community_ID +
                '}';
    }
}
