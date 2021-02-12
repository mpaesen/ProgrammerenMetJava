package jSrc.ch13.dates;

import java.util.Date;

public final class TimFmt extends ComFmt
{
    public static final int TIMFMT_HMS = 0;
    public static final int TIMFMT_ISO = 1;
    public static final int TIMFMT_USA = 2;
    public static final int TIMFMT_EUR = 3;
    public static final int TIMFMT_JIS = 4;

    private String formats[] = {
      "hh/mm/ss", "hh/mm/ss", "hh/mm aa", "hh/mm/ss", "hh/mm/ss"};

    private char defaultSeparators[] = {
      ':', '.', ':', '.', ':'};

    /**
     * Return to parent class our formats instance variable
     */
    protected String[] getFormats()
    {
       return formats;
    }

    /**
     * Return to parent class our defaultSeparators instance variable
     */
    protected char[] getDefaultSeparators()
    {
       return defaultSeparators;
    }

    /**
     * default constructor. Take all defaults
     */
    public TimFmt()
    {
        super();
        format = TIMFMT_ISO;
    }


    /**
     *  Constructor that takes both a format and a separator
     *  @param format - one of the public int constants defined in this class
     *  @param separator - character to use for the separator
     */
    public TimFmt(int format, char separator)
    {
        super(format, separator);
    }
    /**
     *  Constructor that takes only a format, and uses default separator
     *  @param format - one of the public int constants defined in this class
     */
    public TimFmt(int format)
    {
        super(format);
    }


    /**
     * main method to test this class
     */
    public static void main(String args[])
    {
        TimFmt me = new TimFmt();
        Date   date = new Date();
        System.out.println(me.format(date));
        System.out.println();
        for (int idx=TimFmt.TIMFMT_HMS; idx<=TimFmt.TIMFMT_JIS; idx++)
        {
           me.setFormat(idx);
           System.out.println(me.format(date));
        }
        System.out.println();
        for (int idx=TimFmt.TIMFMT_HMS; idx<=TimFmt.TIMFMT_JIS; idx++)
        {
           me.setFormat(idx);
           me.setSeparator('.');
           System.out.println(me.format(date));
        }
    }

} // end TimFmt class
