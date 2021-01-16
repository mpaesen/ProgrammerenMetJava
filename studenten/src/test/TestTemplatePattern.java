import com.vaccination.prod.enums.*;
import com.vaccination.prod.template.*;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestTemplatePattern {



    Action action ; //= VaccineFactory.getVaccine(VaccineEnum.values()[rndNr].name());

    @Test
    public void testActionStep1() {

        action=new Step1Action(StepName.values()[0].getDescription(),ActionStep1.values()[1].getDescription());
        assertEquals(action.getClass().getSimpleName(),("Step1Action"));


    }

    @Test
    public void testActionStep2() {

        action=new Step2Action(StepName.values()[1].getDescription(),ActionStep1.values()[1].getDescription());
        assertEquals(action.getClass().getSimpleName(),("Step2Action"));


    }

    @Test
    public void testActionStep3() {

        action=new Step3Action(StepName.values()[2].getDescription(),ActionStep1.values()[1].getDescription());
        assertEquals(action.getClass().getSimpleName(),("Step3Action"));


    }

    @Test
    public void testActionStep4() {

        action=new Step4Action(StepName.values()[3].getDescription(),ActionStep1.values()[1].getDescription());
        assertEquals(action.getClass().getSimpleName(),("Step4Action"));


    }

    @Test
    public void testActionStep5() {

        action=new Step5Action(StepName.values()[4].getDescription(),ActionStep1.values()[1].getDescription());
        assertEquals(action.getClass().getSimpleName(),("Step5Action"));


    }




}
