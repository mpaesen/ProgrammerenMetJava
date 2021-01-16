package com.vaccination.prod.template;
import com.vaccination.prod.enums.StepName;

public class Step3Action extends Action{

    public Step3Action(String name, String description)
    {
        super(name, description);
    }

    public void setDescription()
    {
        this.description= StepName.STEP3.getDescription();
    }

    public void setName()
    {
        this.name=StepName.STEP3.name();
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
