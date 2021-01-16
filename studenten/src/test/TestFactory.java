
import com.vaccination.prod.enums.*;
import com.vaccination.prod.factory.*;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestFactory {



    @Test
    public void testCreateCovid19() {

        Vaccine tmpVaccine = VaccineFactory.getVaccine(VaccineEnum.values()[0].name());
        assertEquals(tmpVaccine.getClass().getSimpleName(),("Covid19"));


    }
    @Test
    public void testCreateInfluenza() {
        Vaccine tmpVaccine = VaccineFactory.getVaccine(VaccineEnum.values()[1].name());
        assertEquals(tmpVaccine.getClass().getSimpleName(),("Influenza"));
    }

    @Test
    public void testCreateDTP() {
        Vaccine tmpVaccine = VaccineFactory.getVaccine(VaccineEnum.values()[2].name());
        assertEquals(tmpVaccine.getClass().getSimpleName(),("DifterieTetanusPolio"));
    }

    @Test
    public void testCreateHepatitisB() {
        Vaccine tmpVaccine = VaccineFactory.getVaccine(VaccineEnum.values()[3].name());
        assertEquals(tmpVaccine.getClass().getSimpleName(),("HepatitisB"));

    }



}
