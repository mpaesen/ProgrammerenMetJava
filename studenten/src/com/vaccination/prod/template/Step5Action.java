package com.vaccination.prod.template;
import com.vaccination.prod.enums.StepName;

public class Step5Action extends Action{

    public Step5Action(String name, String description)
    {
        super(name, description);
    }

    public void setDescription()
    {
        this.description= StepName.STEP5.getDescription();
    }

    public void setName()
    {
        this.name=StepName.STEP5.name();
    }
    public String getName()
    {
        return this.name;
    }
    public String getDescription()
    {
        return this.description;
    }
}
