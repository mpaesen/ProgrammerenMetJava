import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class InfoArea extends JPanel implements ActionListener
{
    private File        outFile;
    private PrintWriter outFileStream;
    private String      logfile;
    private JTextField  field;
    private JButton     plusButton;
    private PropertyChangeSupport propertyChange;

    public InfoArea(String logfileName)
    {
        setLayout(new BorderLayout());
        logfile = logfileName;
        outFile = new File(logfileName);
        field = new JTextField();
        field.setBackground(Color.cyan);
        field.setEditable(false);
        field.setBorder(BorderFactory.createLoweredBevelBorder());
        plusButton = new JButton(" + ");
        plusButton.addActionListener(this);
        plusButton.setBorder(BorderFactory.createRaisedBevelBorder());
        add(field,BorderLayout.CENTER);
        add(plusButton,BorderLayout.EAST);
        propertyChange = new PropertyChangeSupport(this);
    }

    /** default ctor */
    public InfoArea()
    {
        this("c:" + File.separatorChar + "InfoArea.log");
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChange.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        propertyChange.removePropertyChangeListener(listener);
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
        String oldValue = field.getText();
        field.setText(text);
        field.setCaretPosition(0); // move cursor back to column 1
        logMessage(text);
        propertyChange.firePropertyChange("text",oldValue,text);
    }

    public String getText()
    {
        return field.getText();
    }

    public void actionPerformed(ActionEvent evt)
    {
        if (evt.getSource() == plusButton)
          {
             WWLog logWindow = new WWLog(outFile);
             field.setText("");
          }
    }
}