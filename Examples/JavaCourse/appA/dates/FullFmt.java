package appA.dates;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FullFmt implements Formatable
{

    public String format(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("'Date: 'E, MMMM d 'Time: 'hh:mm a z");
        return sdf.format(date);
    }

}
