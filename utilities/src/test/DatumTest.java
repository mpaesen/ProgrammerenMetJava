package test;

import org.junit.Before;
import org.junit.Test;
import utilities.Datum;
import utilities.DatumException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class DatumTest {
    private Datum datumString;
    private Datum datumCopy;
    private Datum datumInt;
    private Datum datumDefault;

    @Before
    public void setUp() throws DatumException {
        datumString = new Datum("21/09/2009");
        datumCopy = new Datum(datumString);
        datumInt = new Datum(21, 9, 2009);
        datumDefault = new Datum();
    }

    @Test
    public void testToString() {
        // fail("Not yet implemented");
        System.out.println(datumDefault);
    }

    @Test
    public void testEquals() {
        // fail("Not yet implemented");
        assertTrue(datumString.equals(datumCopy));
        assertTrue(datumCopy.equals(datumInt));
    }

    @Test
    public void testCompareTo() {
        // fail("Not yet implemented");
        assertTrue(datumString.compareTo(datumCopy) == 0);
        assertTrue(datumCopy.compareTo(datumInt) == 0);
    }

    @Test
    public void testKleinerDan() {
        datumInt.setJaar(datumInt.getJaar() + 3);
        assertTrue(datumString.kleinerDan(datumInt));
    }

    @Test
    public void testVerschilInJaren() {
        datumInt.setJaar(datumInt.getJaar() + 3);
        assertTrue(datumInt.verschilInJaren(datumString) == 3);
    }

    @Test
    public void testVerschilInMaanden() {
        datumInt.setJaar(datumInt.getJaar() + 3);
        datumInt.setMaand(datumInt.getMaand() + 2);
        assertTrue(datumInt.verschilInMaanden(datumString) == 38);
    }

    @Test
    public void testIsLeap() {
        datumDefault.setJaar(2008);
        assertTrue(datumDefault.isLeapYear());
        datumDefault.setJaar(2012);
        assertTrue(datumDefault.isLeapYear());
        datumDefault.setJaar(2000);
        assertTrue(datumDefault.isLeapYear());
        datumDefault.setJaar(1900);
        assertFalse(datumDefault.isLeapYear());
        datumDefault.setJaar(2009);
        assertFalse(datumDefault.isLeapYear());
        datumDefault.setJaar(1800);
        assertFalse(datumDefault.isLeapYear());
        datumDefault.setJaar(2010);
        assertFalse(datumDefault.isLeapYear());
    }


    @Test
    public void testVerschilInDagen() {

        datumInt.setJaar(datumInt.getJaar() + 1);// 2010-09-21
        datumInt.setMaand(datumInt.getMaand() + 1);// 2010-10-21
        datumInt.setDag(datumInt.getDag() + 1);// 2010-10-22
        assertTrue((365 + 30 + 1) != datumInt.verschilInDagen(datumString));
        // 2010-10-22 - 2009-09-21
        datumInt.setJaar(datumInt.getJaar() + 2);// 2012-10-22
        datumInt.setMaand(datumInt.getMaand() + 2);// 2012-12-22
        datumInt.setDag(datumInt.getDag() + 2);// 2012-12-24
        assertTrue(datumInt.verschilInDagen(datumString) == 1192);
        // 2012-12-24 - 2009-09-21
    }

    @Test
    public void testaantalDagenInHuidigeJaar() {
        assertTrue(datumDefault.aantalDagenInHuidigeJaar() == 365);
        datumDefault.setJaar(datumDefault.getJaar() + 1);
        assertTrue(datumDefault.aantalDagenInHuidigeJaar() == 365);
        datumDefault.setJaar(datumDefault.getJaar() + 1);
        assertTrue(datumDefault.aantalDagenInHuidigeJaar() == 366);
        datumDefault.setJaar(datumDefault.getJaar() + 1);
        assertTrue(datumDefault.aantalDagenInHuidigeJaar() == 365);
        datumDefault.setJaar(datumDefault.getJaar() + 1);
        assertTrue(datumDefault.aantalDagenInHuidigeJaar() == 365);
        datumDefault.setJaar(datumDefault.getJaar() + 1);
        assertTrue(datumDefault.aantalDagenInHuidigeJaar() == 365);
    }

    @Test
    public void testMaandTextFormaat() {
        assertTrue(datumInt.toString().equals(
                datumInt.getDag() + " " + datumInt.getMaandText() + " "
                        + datumInt.getJaar()));
    }

    @Test
    public void testLaatsteDagVanDeMaand() {
        Datum laatste = null;

        try {
            Datum test = new Datum();
            for (int i = 0; i < 12; i++) {
                laatste = Datum.laatsteDagVanDeMaand(test);
                test.veranderDatum(30);
                System.out.println(laatste);
            }
        } catch (DatumException e) {
            e.printStackTrace();
        }
    }

}
