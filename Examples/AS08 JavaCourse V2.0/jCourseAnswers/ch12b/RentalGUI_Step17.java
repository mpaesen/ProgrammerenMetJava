import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentalGUI extends JFrame implements ActionListener
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
        getContentPane().setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(4,1));

        rentButton   = new BigButton("Rent...");
        returnButton = new BigButton("Return...");
        displayButton= new BigButton("Display");
        closeButton  = new BigButton("Close");

        rentButton.addActionListener(this);
        returnButton.addActionListener(this);
        displayButton.addActionListener(this);
        closeButton.addActionListener(this);

        buttons.add(rentButton);
        buttons.add(returnButton);
        buttons.add(displayButton);
        buttons.add(closeButton);

        infoArea = new InfoArea();

        getContentPane().add(buttons, BorderLayout.CENTER);
        getContentPane().add(infoArea,BorderLayout.SOUTH);

        setSize(175,300);
        setLocation(200,300);
        closer = new FrameListener(this,true);
        addWindowListener(closer);
        //show();
        rental = new RentalMethods();
        rental.populateLot();
        setVisible(true);
    } // end ctor

    public void actionPerformed(ActionEvent evt)
    {
        Object srcObj = evt.getSource();
        if (srcObj == rentButton)
          {
            RentWindow rentWindow = new RentWindow(this);
            rentWindow.setVisible(true);
          }
        else if (srcObj == returnButton)
          {
            ReturnWindow returnWindow = new ReturnWindow(this);
            returnWindow.setVisible(true);
          }
        else if (srcObj == displayButton)
          {
            //DisplayWindow displayWindow = new DisplayWindow(this);
            DisplayWindowInTable displayWindow = new DisplayWindowInTable(this);
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

    public static void main(String args[])
    {
        RentalGUI app = new RentalGUI();
    } // end main

} // end RentalGUI
