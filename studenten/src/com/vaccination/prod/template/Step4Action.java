package com.vaccination.prod.template;
import com.vaccination.prod.enums.StepName;

public class Step4Action extends Action{

    public Step4Action(String name, String description)
    {
        super(name, description);
    }

    public void setDescription()
    {
        this.description= StepName.STEP4.getDescription();
    }

    public void setName()
    {
        this.name=StepName.STEP4.name();
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
