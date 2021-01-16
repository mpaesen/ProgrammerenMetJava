package com.vaccination.prod.enums;

public enum ActionStep3 {


    ACTION1("Ontdooien tot kamertemperatuur nadien de innenting uitvoeren binnen de 2uur."),
    ACTION2("Uit verpakking halen en instructies van fabrikant volgen"),
    ACTION3("naald bevestigen"),
    ACTION4("Componenten mengen");



    private String description;
    public String getDescription(){return description;}
    ActionStep3(String description){this.description=description;}

}
