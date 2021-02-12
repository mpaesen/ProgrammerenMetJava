import javax.swing.*;
import java.awt.*;

public class RentalGUI extends JFrame
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
        getContentPane().setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(4,1));

        rentButton   = new BigButton("Rent...");
        returnButton = new BigButton("Return...");
        displayButton= new BigButton("Display");
        closeButton  = new BigButton("Close");

        buttons.add(rentButton);
        buttons.add(returnButton);
        buttons.add(displayButton);
        buttons.add(closeButton);

        infoArea = new InfoArea();

        getContentPane().add(buttons, BorderLayout.CENTER);
        getContentPane().add(infoArea,BorderLayout.SOUTH);

        setSize(175,300);
        setLocation(200,300);
        //show();
        setVisible(true);
    } // end ctor

    public static void main(String args[])
    {
        RentalGUI app = new RentalGUI();
    } // end main

} // end RentalGUI
