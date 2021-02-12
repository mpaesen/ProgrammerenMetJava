import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentalGUI extends Frame implements ActionListener
{
    private BigButton rentButton;
    private BigButton returnButton;
    private BigButton displayButton;
    private BigButton closeButton;
    private InfoArea  infoArea;
    private FrameListener closer;

    public RentalGUI()
    {
        super("Rental Program");
        setLayout(new BorderLayout());

        Panel buttons = new Panel();
        buttons.setLayout(new GridLayout(4,1));

        rentButton   = new BigButton("Rent...");
        rentButton.addActionListener(this);
        returnButton = new BigButton("Return...");
        returnButton.addActionListener(this);
        displayButton= new BigButton("Display");
        displayButton.addActionListener(this);
        closeButton  = new BigButton("Close");
        closeButton.addActionListener(this);

        buttons.add(rentButton);
        buttons.add(returnButton);
        buttons.add(displayButton);
        buttons.add(closeButton);

        infoArea = new InfoArea();

        add(buttons,"Center");
        add(infoArea,"South");

        setSize(175,300);
        setLocation(200,300);

        closer = new FrameListener(this,true);
        addWindowListener(closer);

        //show();
        setVisible(true);
    } // end ctor

    public static void main(String args[])
    {
        RentalGUI app = new RentalGUI();
    } // end main

    public void actionPerformed(ActionEvent evt)
    {
        Object srcObj = evt.getSource();
        if (srcObj == rentButton)
          {
            RentWindow rentWindow = new RentWindow(this);
            //rentWindow.show();
            rentWindow.setVisible(true);
          }
        else if (srcObj == returnButton)
          {
          }
        else if (srcObj == displayButton)
          {
          }
        else if (srcObj == closeButton)
          closer.closeWindow();
    }

} // end RentalGUI
