import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonButtons extends Panel implements ActionListener
{
    private Button okButton;
    private Button cancelButton;
    private CommonButtonInterface caller;

    public CommonButtons(CommonButtonInterface caller)
    {
        super();
        this.caller = caller;
        setLayout(new GridLayout(1,2));
        okButton     = new Button("OK");
        cancelButton = new Button("Cancel");
        add(okButton);
        add(cancelButton);
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
    } // end constructor

    public void actionPerformed(ActionEvent evt)
    {
        Button button = (Button)evt.getSource();
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
        okButton.setLabel(text);
    }
} // end CommonButtons class
