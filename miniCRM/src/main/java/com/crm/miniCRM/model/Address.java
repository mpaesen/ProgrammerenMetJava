package com.crm.miniCRM.model;



import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "person_address")
    List<Person> person_address;

    private String street;
    private String number;
    private String box;
    private String zip;
    private String city;
    private String country;
    private String type;

    public Address(){}

    public Address(String street, String number, String box, String zip, String city, String country, String type) {
        this.street = street;
        this.number = number;
        this.box = box;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Address{id='"+id +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", box='" + box + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
