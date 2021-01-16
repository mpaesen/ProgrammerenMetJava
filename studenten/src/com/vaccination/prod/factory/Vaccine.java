package com.vaccination.prod.factory;
import com.vaccination.prod.template.Action;
import java.util.LinkedList;

public interface Vaccine {
    LinkedList<Action> stepActionList = new LinkedList<Action>();
    String vaccineName="";
    public Action getActions(int step);
    public void setAction(Action stepAction);
    public String getVaccineName();
}
