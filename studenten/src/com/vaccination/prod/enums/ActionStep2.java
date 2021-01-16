package com.vaccination.prod.enums;

public enum ActionStep2 {

    ACTION1("Stuur sms"),
    ACTION2("Receptionist geeft status door"),
    ACTION3("Status visualiseren op groot scherm"),
    ACTION4("Omroepen via intercom");


    private String description;
    public String getDescription(){return description;}
    ActionStep2(String description){this.description=description;}


}
