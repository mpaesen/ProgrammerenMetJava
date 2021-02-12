import java.text.SimpleDateFormat;
import java.util.Date;

public class DatFmt
{
    public static final int DATFMT_MDY = 0;
    public static final int DATFMT_DMY = 1;
    public static final int DATFMT_YMD = 2;
    public static final int DATFMT_JUL = 3;
    public static final int DATFMT_USA = 4;
    public static final int DATFMT_EUR = 5;
    public static final int DATFMT_ISO = 6;
    public static final int DATFMT_JIS = 7;

    private int  format = DATFMT_ISO;
    private char separator = (char)-1; // -1 implies use default

    private String formats[] = {
      "MM/dd/yy",   "dd/MM/yy",   "yy/MM/dd",   "yy/DDD",
      "MM/dd/yyyy", "dd/MM/yyyy", "yyyy/MM/dd", "yyyy/MM/dd"};

    private char defaultSeparators[] = {
      '/', '/', '/', '/', '/', '.', '-', '-'};

    /**
     * default constructor. Take all defaults
     */
    public DatFmt()
    {
    }

    /**
     *  Constructor that takes both a format and a separator
     *  @param format - one of the public int constants defined in this class
     *  @param separator - character to use for the separator
     */
    public DatFmt(int format, char separator)
    {
        this.format = format;
        this.separator = separator;
    }

    /**
     *  Constructor that takes only a format, and uses default separator
     *  @param format - one of the public int constants defined in this class
     */
    public DatFmt(int format)
    {
        this.format = format;
    }

    /**
     *  set AS/400 style date format
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
        DatFmt me = new DatFmt();
        Date   date = new Date();
        System.out.println(me.format(date));
        System.out.println();
        for (int idx=DatFmt.DATFMT_MDY; idx<=DatFmt.DATFMT_JIS; idx++)
        {
           me.setFormat(idx);
           System.out.println(me.format(date));
        }
        System.out.println();
        for (int idx=DatFmt.DATFMT_MDY; idx<=DatFmt.DATFMT_JIS; idx++)
        {
           me.setFormat(idx);
           me.setSeparator('.');
           System.out.println(me.format(date));
        }
    }

} // end DatFmt class
