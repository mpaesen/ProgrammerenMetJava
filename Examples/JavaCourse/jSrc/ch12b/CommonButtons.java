package jSrc.ch12b;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonButtons extends JPanel implements ActionListener
{
    private JButton okButton;
    private JButton cancelButton;
    private CommonButtonInterface caller;

    public CommonButtons(CommonButtonInterface caller)
    {
        super();
        this.caller = caller;
        setLayout(new GridLayout(1,2));
        okButton     = new JButton("OK");
        cancelButton = new JButton("Cancel");
        add(okButton);
        add(cancelButton);
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        okButton.setBorder(BorderFactory.createRaisedBevelBorder());
        cancelButton.setBorder(BorderFactory.createRaisedBevelBorder());
    } // end constructor

    public void actionPerformed(ActionEvent evt)
    {
        JButton button = (JButton)evt.getSource();
        if (button == okButton)
          {
             caller.okPressed();
          }
        else if (button == cancelButton)
          {
             caller.cancelPressed();
          }
    } // end actionPerformed

    public void setOKButtonText(String text)
    {
        okButton.setText(text);
    }
} // end CommonButtons class
