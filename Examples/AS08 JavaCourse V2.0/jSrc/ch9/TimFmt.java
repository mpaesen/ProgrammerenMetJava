import java.text.SimpleDateFormat;
import java.util.Date;

public class TimFmt
{
    public static final int TIMFMT_HMS = 0;
    public static final int TIMFMT_ISO = 1;
    public static final int TIMFMT_USA = 2;
    public static final int TIMFMT_EUR = 3;
    public static final int TIMFMT_JIS = 4;

    private int  format = TIMFMT_ISO;
    private char separator = (char)-1; // -1 implies use default

    private String formats[] = {
      "hh/mm/ss", "hh/mm/ss", "hh/mm aa", "hh/mm/ss", "hh/mm/ss"};

    private char defaultSeparators[] = {
      ':', '.', ':', '.', ':'};

    /**
     * default constructor. Take all defaults
     */
    public TimFmt()
    {
    }

    /**
     *  Constructor that takes both a format and a separator
     *  @param format - one of the public int constants defined in this class
     *  @param separator - character to use for the separator
     */
    public TimFmt(int format, char separator)
    {
        this.format = format;
        this.separator = separator;
    }

    /**
     *  Constructor that takes only a format, and uses default separator
     *  @param format - one of the public int constants defined in this class
     */
    public TimFmt(int format)
    {
        this.format = format;
    }

    /**
     *  set AS/400 style format
     *  @param format - one of the public int constants defined in this class
     */
    public void setFormat(int format)
    {
        this.format = format;
    }

    /**
     *  Set separator character for this format
     *  By default, appropriate default for the format is used
     *  @param separator - character to use for the separator. Pass -1 to use default
     */
    public void setSeparator(char separator)
    {
        this.separator = separator;
    }

    /**
     * Format a given date according to settings
     * @param date - date to be formatted
     */
    public String format(Date date)
    {
        String formatString = formats[format];
        if (separator != (char)-1)
          formatString = formatString.replace('/',separator);
        else
          formatString = formatString.replace('/',defaultSeparators[format]);
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        return sdf.format(date);
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