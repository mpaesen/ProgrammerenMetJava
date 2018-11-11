package test;

import utilities.Datum;
import utilities.DatumException;

import java.util.Arrays;

public class TestDatum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String datArray[] = {"12/09/2009", "29/03/2009", "30/09/2009",
                "20/09/2009", "11/12/2009", "22/02/2009", "31/12/2008",
                "31/12/2009"};
        Datum datums[] = new Datum[datArray.length];
        for (int i = 0; i < datArray.length; i++) {
            try {
                datums[i] = new Datum(datArray[i]);
            } catch (DatumException exception) {
                System.err.println(exception);
            }
        }
        // datums = Datum.sorteerDatums(datums);
        Arrays.sort(datums);
        for (int i = 0; i < datums.length; i++) {
            System.out.println(datums[i]);
        }
        System.out.println("Er zijn " + datums[datums.length - 1].verschilInDagen(datums[0]) + " dagen tussen " + datums[0] + " en "
                + datums[datums.length - 1] + ".");
    }
}
