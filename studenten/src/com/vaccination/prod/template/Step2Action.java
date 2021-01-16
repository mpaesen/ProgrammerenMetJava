package com.vaccination.prod.template;
import com.vaccination.prod.enums.*;

public class Step2Action extends Action{

       public Step2Action(String name, String description)
        {
            super(name, description);
        }

        public void setDescription()
        {
            this.description= StepName.STEP2.getDescription();
        }

        public void setName()
        {
            this.name=StepName.STEP2.name();
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
