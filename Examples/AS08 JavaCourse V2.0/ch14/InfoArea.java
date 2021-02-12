package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;

public class InfoArea extends JPanel implements ActionListener, ItemSelectable {
    public InfoArea(String logfile) {
        this.logfile = logfile;
        outFile = new File(logfile);
        setLayout(new BorderLayout());
        field = new JTextField();
        field.setBackground(Color.cyan);
        field.setEditable(false);
        field.setBorder(BorderFactory.createLoweredBevelBorder());
        plusButton = new JButton(" + ");
        plusButton.addActionListener(this);
        plusButton.setBorder(BorderFactory.createRaisedBevelBorder());
        add(field, BorderLayout.CENTER);
        add(plusButton, BorderLayout.EAST);
        propertyChange = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChange.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChange.removePropertyChangeListener(listener);
    }

    public InfoArea() throws IOException {
        this("c:" + File.separatorChar + "InfoArea.log");
    }

    public String getText() { return field.getText(); }

    public void setText(String text) {
        String oldValue = field.getText();
        field.setText(text);
        field.setCaretPosition(0); // move cursor back to column 1
        logMessage(text); //write it to disk
        propertyChange.firePropertyChange("text", oldValue, text);
        /*  Bound property changes are only popagated when the new property value
            is different from the previous property value, for performance rasons.
        */
        fireItemStateChanged(new ItemEvent(this,0,text,ItemEvent.SELECTED));
        //listeners are informed of the change
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == plusButton) {
            WWLog logWindow = new WWLog(outFile);
            field.setText("");
        }
    }

    public void logMessage(String message) {
        try {
            outFileStream = new PrintWriter(new FileOutputStream(outFile.getAbsolutePath(), true));
            outFileStream.write(message);
            outFileStream.flush(); //flush to disk
            outFileStream.close();
            outFileStream = null;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void clearLog() {
        if (outFile.exists())
            outFile.delete();
    }

    public void addItemListener(ItemListener newListener) {
        itemListener = AWTEventMulticaster.add(itemListener, newListener);
    }

    public void removeItemListener(ItemListener newListener) {
                itemListener = AWTEventMulticaster.remove(itemListener, newListener);
    }

    public void fireItemStateChanged(ItemEvent evt) {
        if(itemListener != null)
            itemListener.itemStateChanged(evt);
    }

    public Object[] getSelectedObjects() {
        String[] items = new String[1];
		items[0] = field.getText();
	        return items;
    }

    private File outFile;
    private PrintWriter outFileStream;
    private String logfile;
    private JTextField field;
    private JButton plusButton;
    private PropertyChangeSupport propertyChange;
    private ItemListener itemListener = null;
}
