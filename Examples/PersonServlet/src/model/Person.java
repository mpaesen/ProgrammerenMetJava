// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Person.java

package model;


public class Person
{

    public Person()
    {
        this(0, "", "", "", "", "", "");
    }

    public Person(int id, String name, String street, String postcode, String city, String gsm, String email)
    {
        setId(id);
        setName(name);
        setStreet(street);
        setPostcode(postcode);
        setCity(city);
        setGsm(gsm);
        setEmail(email);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getGsm()
    {
        return gsm;
    }

    public void setGsm(String gsm)
    {
        this.gsm = gsm;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    private int id;
    private String name;
    private String street;
    private String postcode;
    private String city;
    private String gsm;
    private String email;
}
