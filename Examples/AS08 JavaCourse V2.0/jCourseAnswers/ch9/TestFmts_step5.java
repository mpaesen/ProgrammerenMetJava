import java.util.Date;

public class TestFmts
{
    public static void displayHeader(ComFmt fmtObj)
    {
        System.out.println(fmtObj.format(new Date()));
    }

    /**
     *  command line control
     */
    public static void main(String args[])
    {
        DatFmt fmt1 = new DatFmt();
        TimFmt fmt2 = new TimFmt();
        displayHeader(fmt1);
        displayHeader(fmt2);
    } // end main
}