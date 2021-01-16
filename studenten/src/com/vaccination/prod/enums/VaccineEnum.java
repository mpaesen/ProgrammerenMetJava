package com.vaccination.prod.enums;

public enum VaccineEnum {
    COVID19("Covid19"),
    INFLUENZA("Influenza"),
    DTP("DTP"),
    HEPATITISB("HepatitisB");


    private String description;
    public String getDescription(){return description;}
    VaccineEnum(String description){this.description=description;}

}




