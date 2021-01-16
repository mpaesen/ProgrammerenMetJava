package com.vaccination.prod;

public class Patient {
    private String name = "";
    private String socialSecurityNumber="";

    public Patient(String name, String socialSecurityNumber) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getName() {
        return name;
    }
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
}
