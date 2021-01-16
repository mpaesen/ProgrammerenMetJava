package com.vaccination.prod.enums;

public enum ActionStep5 {
    ACTION1("Mag na toedienen onmiddellijk vertrekken"),
    ACTION2("Na 20 minuten controle op alergische reacties"),
    ACTION3("pleister voorzien"),
    ACTION4("registratie in het systeem");



    private String description;
    public String getDescription(){return description;}
    ActionStep5(String description){this.description=description;}


}
