import java.text.SimpleDateFormat;
import java.util.Date;

/** Common Date/Time Formatting class */
abstract class ComFmt implements Formatable
{
    protected int  format;
    protected char separator = (char)-1; // -1 implies use default

    /**
     * default constructor. Take all defaults
     */
    public ComFmt()
    {
    }

    /**
     *  Constructor that takes both a format and a separator
     *  @param format - one of the public int constants defined in this class
     *  @param separator - character to use for the separator
     */
    public ComFmt(int format, char separator)
    {
        this.format = format;
        this.separator = separator;
    }

    /**
     *  Constructor that takes only a format, and uses default separator
     *  @param format - one of the public int constants defined in this class
     */
    public ComFmt(int format)
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
        String formats[] = getFormats();
        char   defaultSeparators[] = getDefaultSeparators();
        String formatString = formats[format];
        if (separator != (char)-1)
          formatString = formatString.replace('/',separator);
        else
          formatString = formatString.replace('/',defaultSeparators[format]);
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        return sdf.format(date);
    }

    protected abstract String[] getFormats();
    protected abstract char[] getDefaultSeparators();
} // end ComFmt class