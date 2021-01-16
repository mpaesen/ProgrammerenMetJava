package com.vaccination.prod.factory;
import com.vaccination.prod.enums.VaccineEnum;
import com.vaccination.prod.template.Action;
import java.util.LinkedList;

public class DifterieTetanusPolio  implements Vaccine {

    public DifterieTetanusPolio() {
        this.vaccineName= VaccineEnum.DTP.name();
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
