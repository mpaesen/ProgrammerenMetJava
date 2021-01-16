package com.vaccination.prod.factory;
import com.vaccination.prod.enums.VaccineEnum;
import com.vaccination.prod.template.Action;
import java.util.LinkedList;

public class Covid19 implements Vaccine {

    public Covid19() {
        this.vaccineName= VaccineEnum.COVID19.name();
    }

    private LinkedList<Action> stepActionList = new LinkedList<Action>();
    private String vaccineName;
    public Action getActions(int step)
    {
        return stepActionList.get(step);
    };
    public void setAction(Action stepAction)
    {
        stepActionList.add(stepAction);
    }
    public String getVaccineName()
    {
        return vaccineName;
    }

}
