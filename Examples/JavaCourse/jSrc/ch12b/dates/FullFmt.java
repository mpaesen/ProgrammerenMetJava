package jSrc.ch12b.dates;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FullFmt implements Formatable
{
    public String format(Date date)
    {
        SimpleDateFormat fmt = new SimpleDateFormat("'Date: 'E, MMMM d 'Time: 'hh:mm a z");
        return fmt.format(date);
    }
}