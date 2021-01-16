import com.vaccination.prod.enums.*;
import org.junit.*;



import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnumTest {

    static HashSet<String> stepNameValues = new HashSet<String>();
    static HashSet<String> actionStep1Values = new HashSet<String>();
    static HashSet<String> actionStep2Values = new HashSet<String>();
    static HashSet<String> actionStep3Values = new HashSet<String>();
    static HashSet<String> actionStep4Values = new HashSet<String>();
    static HashSet<String> actionStep5Values = new HashSet<String>();
    static HashSet<String> vaccineValues = new HashSet<String>();

    @BeforeClass
    public static void startTest(){
        System.out.println("**************  Start enumtest **************");
        for (StepName item : StepName.values()) {
            stepNameValues.add(item.name());
        }
        for (StepName item : StepName.values()) {
            stepNameValues.add(item.name());
        }
        for (ActionStep2 item : ActionStep2.values()) {
            actionStep2Values.add(item.name());
        }
        for (ActionStep3 item : ActionStep3.values()) {
            actionStep3Values.add(item.name());
        }
        for (ActionStep4 item : ActionStep4.values()) {
            actionStep4Values.add(item.name());
        }
        for (ActionStep5 item : ActionStep5.values()) {
            actionStep5Values.add(item.name());
        }
        for (ActionStep1 item : ActionStep1.values()) {
            actionStep1Values.add(item.name());
        }

        for (VaccineEnum item : VaccineEnum.values()) {
            vaccineValues.add(item.name());
        }



    }


    /**************************
     *  TEST Stepname enum
     *************************/

    @Test
    public void testStepNameEnumNotEmpty() {
        assertTrue(StepName.values().length > 0);
    }


    @Test
    public void testStepNameGeldigeWaardeSTEP2() {
        assertTrue(stepNameValues.contains("STEP2"));
    }
    @Test
    public void testStepNameGeldigeDescriptionToedienen() {
        assertTrue(StepName.STEP4.getDescription().equals("Toedienen"));
    }
    @Test
    public void testStepNameOnGeldigeWaarde() {
        assertFalse(stepNameValues.contains("OngeldigeWaarde$"));
    }




    /**************************
     *  TEST ActionStep1 enum
     *************************/

    @Test
    public void testActionStep1EnumNotEmpty() {
        assertTrue(ActionStep1.values().length > 0);
    }
    @Test
    public void testActionStep1GeldigeWaardeAction2() {
        assertTrue(actionStep1Values.contains("ACTION2"));
    }
    @Test
    public void testActionStep1GeldigeDescriptionRegistreer() {
        assertTrue(ActionStep1.ACTION4.getDescription().equals("Spoedprocedure"));
    }
    @Test
    public void testActionStep1OnGeldigeWaarde() {
        assertFalse(actionStep1Values.contains("OngeldigeWaarde$"));
    }


    /**************************
     *  TEST ActionStep2 enum
     *************************/

    @Test
    public void testActionStep2EnumNotEmpty() {
        assertTrue(ActionStep2.values().length > 0);
    }
    @Test
    public void testActionStep2GeldigeWaardeAction2() {
        assertTrue(actionStep2Values.contains("ACTION2"));
    }
    @Test
    public void testActionStep2eldigeDescriptionRegistreer() {
        assertTrue(ActionStep2.ACTION1.getDescription().equalsIgnoreCase("Stuur SMS"));
    }
    @Test
    public void testActionStep2OnGeldigeWaarde() {
        assertFalse(actionStep2Values.contains("OngeldigeWaarde$"));
    }


    /**************************
     *  TEST ActionStep3 enum
     *************************/

    @Test
    public void testActionStep3EnumNotEmpty() {
        assertTrue(ActionStep3.values().length > 0);
    }
    @Test
    public void testActionStep3GeldigeWaardeAction2() {
        assertTrue(actionStep3Values.contains("ACTION2"));
    }
    @Test
    public void testActionStep3GeldigeDescriptionnaaldbevestigen() {
        assertTrue(ActionStep3.ACTION3.getDescription().equals("naald bevestigen"));
    }
    @Test
    public void testActionStep3OnGeldigeWaarde() {
        assertFalse(actionStep3Values.contains("OngeldigeWaarde$"));
    }




    /**************************
     *  TEST ActionStep4 enum
     *************************/

    @Test
    public void testActionStep4EnumNotEmpty() {
        assertTrue(ActionStep4.values().length > 0);
    }
    @Test
    public void testActionStep4GeldigeWaardeAction2() {
        assertTrue(actionStep4Values.contains("ACTION2"));
    }
    @Test
    public void testActionStep4GeldigeDescriptionInnamemetglaswater() {
        assertTrue(ActionStep4.ACTION2.getDescription().equals("Inname met glas water"));
    }
    @Test
    public void testActionStep4OnGeldigeWaarde() {
        assertFalse(actionStep4Values.contains("OngeldigeWaarde$"));
    }



    /**************************
     *  TEST ActionStep5 enum
     *************************/

    @Test
    public void testActionStep5EnumNotEmpty() {
        assertTrue(ActionStep5.values().length > 0);
    }
    @Test
    public void testActionStep5GeldigeWaardeAction2() {
        assertTrue(actionStep5Values.contains("ACTION2"));
    }
    @Test
    public void testActionStep5GeldigeDescriptionregistratieinhetsysteem() {
        assertTrue(ActionStep5.ACTION4.getDescription().equals("registratie in het systeem"));
    }
    @Test
    public void testActionStep5OnGeldigeWaarde() {
        assertFalse(actionStep5Values.contains("OngeldigeWaarde$"));
    }







    @AfterClass
    public static void endTest(){
        System.out.println("**************  End EnumTest **************");}

}
