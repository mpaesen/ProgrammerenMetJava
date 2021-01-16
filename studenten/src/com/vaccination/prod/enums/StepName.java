package com.vaccination.prod.enums;

public enum StepName {

    STEP1("Registreer"),
    STEP2("Informeer"),
    STEP3("Voorbereiden"),
    STEP4("Toedienen"),
    STEP5("Nazorg");


    private String description;
    public String getDescription(){return description;}
    StepName(String description){this.description=description;}




}
