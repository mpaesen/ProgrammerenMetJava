import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class InfoArea extends JTextField
{
    private File outFile;
    private PrintWriter outFileStream;
    private String logfile;

    public InfoArea(String logfileName)
    {
        logfile = logfileName;
        outFile = new File(logfileName);
        setBackground(Color.cyan);
        setEditable(false);
        setBorder(BorderFactory.createLoweredBevelBorder());
    }

    /** default ctor */
    public InfoArea()
    {
        this("c:" + File.separatorChar + "InfoArea.log");
    }

    /** log string in log file */
    public void logMessage(String message)
    {
        try
        {
            outFileStream =
              new PrintWriter(new FileOutputStream(outFile.getAbsolutePath(),true));
            outFileStream.println(message);
            outFileStream.flush();
            outFileStream.close();
            outFileStream = null;
        }
        catch (IOException exc)
        {
            System.out.println("Error opening file " + logfile);
        }
    }

    /** Clear the message log file by deleting it */
    public void clearLog()
    {
        if (outFile.exists())
          outFile.delete();
    }


    public void setText(String text)
    {
        super.setText(text);
        setCaretPosition(0); // move cursor back to column 1
        logMessage(text);
    }
}