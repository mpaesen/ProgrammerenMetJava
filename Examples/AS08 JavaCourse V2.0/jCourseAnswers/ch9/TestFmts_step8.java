public class TestFmts
{
    public static void displayHeader(Formatable fmtObj)
    {
        System.out.println(fmtObj.format(new java.util.Date()));
    }
    public static void main(String args[])
    {
        DatFmt fmt1 = new DatFmt();
        TimFmt fmt2 = new TimFmt();
        FullFmt fmt3 = new FullFmt();
        displayHeader(fmt1);
        displayHeader(fmt2);
        displayHeader(fmt3);
    }
}
