package com.vaccination.prod.enums;

public enum ActionStep1 {

    ACTION1("Manueel Inschrijven"),
    ACTION2("Inschrijving door patient via online platform"),
    ACTION3("Inschrijving door receptionist"),
    ACTION4("Spoedprocedure");


    private String description;
    public String getDescription(){return description;}
    ActionStep1(String description){this.description=description;}




}
