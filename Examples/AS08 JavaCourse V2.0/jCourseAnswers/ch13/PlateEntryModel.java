//import javax.swing.*;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class PlateEntryModel extends PlainDocument
{
    public static final int MAXLENGTH = 6;

    public void insertString(int offset,
                             String string,
                             AttributeSet attrs)
           throws BadLocationException
    {
        boolean error = false;
        if (string == null)
          super.insertString(offset, string, attrs);
        else
          {
            if (getLength() + string.length() > MAXLENGTH)
              error = true;
            else
            {
                for (int idx=0; (idx<string.length()) && !error; idx++)
                {
                   char currchar = string.charAt(idx);
                   if ((currchar<'0') || (currchar>'9'))
                     error = true;
                }
            }
            if (error)
              Toolkit.getDefaultToolkit().beep();
            else
              super.insertString(offset, string, attrs);
          }
    }
} // end of class PlateEntryModel