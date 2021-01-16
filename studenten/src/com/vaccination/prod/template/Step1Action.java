package com.vaccination.prod.template;
import com.vaccination.prod.enums.*;

public class Step1Action extends Action {

    public Step1Action(String name, String description) {
        super(name, description);
    }

    public void setDescription()
    {
        this.description=StepName.STEP1.getDescription();
    }

    public void setName()
    {
        this.name=StepName.STEP1.name();
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
