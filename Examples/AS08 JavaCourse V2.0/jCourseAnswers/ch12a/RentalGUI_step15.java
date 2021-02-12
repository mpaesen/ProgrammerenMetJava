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

    private RentalMethods rental;

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

        rental = new RentalMethods();
        rental.populateLot();

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
            ReturnWindow returnWindow = new ReturnWindow(this);
            //returnWindow.show();
            returnWindow.setVisible(true);
          }
        else if (srcObj == displayButton)
          {
            DisplayWindow displayWindow = new DisplayWindow(this);
            //displayWindow.show();
            displayWindow.setVisible(true);
          }
        else if (srcObj == closeButton)
          {
            rental.stopThread();
            closer.closeWindow();
          }
    }

    RentalMethods getRentalObject()
    {
        return rental;
    }

    InfoArea getInfoArea()
    {
        return infoArea;
    }
} // end RentalGUI
