package ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

/** Class to test the InfoArea Java Bean */
public class Test extends JFrame implements ActionListener, PropertyChangeListener, ItemListener {
    private InfoArea infoArea;
    private JButton button1, button2, button3;
    private JButton cancelButton;
    private JComboBox infoList;

    /** Default constructor. */
    public Test() {
        super("Chapter 14 Test");
        getContentPane().setLayout(new BorderLayout());
        JPanel buttons = new JPanel(new GridLayout(1, 4));
        button1 = createButton("Message 1", buttons);
        button2 = createButton("Message 2", buttons);
        button3 = createButton("Message 3", buttons);
        cancelButton = createButton("Cancel", buttons);
        try {
            infoArea = new InfoArea();
            //infoArea.addPropertyChangeListener(this);
            infoArea.addItemListener(this);
        } catch (IOException ex) { System.out.println(ex.getMessage()); }
        infoList = new JComboBox();
        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        bottomPanel.add(infoList);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        // An inner class to handle closing events...
        WindowListener closer = new WindowAdapter() {
            public void windowClosing(WindowEvent evt) { close(); }
        };
        addWindowListener(closer);
        pack();
        setVisible(true);
    } // end ctor

    public void propertyChange(PropertyChangeEvent evt) {
        Object obj = evt.getSource();
        if ((obj == infoArea) && (evt.getPropertyName().equals("text"))) {
            infoList.addItem(infoArea.getText());
            infoList.setSelectedItem(infoArea.getText());
        }
    }

    /**
     * Helper method for creating a JButton with the given label, setting its border, registering we want to listen for pressed
     * events, and adding it to the given JPanel
     */
    private JButton createButton(String label, JPanel buttonPanel) {
        JButton newButton = new JButton(label);
        newButton.setBorder(BorderFactory.createRaisedBevelBorder());
        newButton.addActionListener(this);
        buttonPanel.add(newButton);
        return newButton;
    }

    /** Method called by our inner class which in turn is called by Java when the user closes the window. */
    void close() {
        dispose();
        System.exit(0);
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        if (obj == button1)
            infoArea.setText("Message 1");
        else if (obj == button2)
            infoArea.setText("Message 2");
        else if (obj == button3)
            infoArea.setText("Message 3");
        else if (obj == cancelButton)
            close();
    } // end actionPerformed

    public void itemStateChanged(ItemEvent evt){
        Object obj = evt.getSource();
        if(obj == infoArea)
        {
            infoList.addItem(infoArea.getText());
            infoList.setSelectedItem(infoArea.getText());
        }
    }

    public static void main(String args[]) {
        Test me = new Test();
    }
} // end class Test