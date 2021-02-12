/* Generated by Together */
package ch9.dates;

import java.util.Date;

public class TestFmts {
    public static void displayHeader(Formatable fmtObj) {
        System.out.println(fmtObj.format(new Date()));
    }

    public static void main(String[] argv) {
        DatFmt fmt1 = new DatFmt(DatFmt.DATFMT_ISO);
        TimFmt fmt2 = new TimFmt(TimFmt.TIMFMT_ISO);
        displayHeader(fmt1);
        displayHeader(fmt2);
        FullFmt fmt3 = new FullFmt();
        displayHeader(fmt3);
    }
}
