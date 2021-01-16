package com.vaccination.prod.enums;

public enum ActionStep4 {



    ACTION1("Arm ontsmetten en in linkerarm toedienen"),
    ACTION2("Inname met glas water"),
    ACTION3("Arm ontsmetten en in rechterarm toedienen"),
    ACTION4("Intraveneus toedienen");



    private String description;
    public String getDescription(){return description;}
    ActionStep4(String description){this.description=description;}

}
