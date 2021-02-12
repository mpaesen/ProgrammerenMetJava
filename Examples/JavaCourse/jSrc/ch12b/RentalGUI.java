package jSrc.ch12b;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentalGUI extends JFrame implements ActionListener, Runnable
{
    private BigButton rentButton;
    private BigButton returnButton;
    private BigButton displayButton;
    private BigButton closeButton;
    private JButton   connectButton;
    private JButton   disConnectButton;
    private InfoArea  infoArea;
    private FrameListener closer;
    private int       runRequest = 0;
    private static final int RUN_CONNECT = 0;

    private RentalConnection ourDB;

    /**
     * Constructor
     */
    public RentalGUI()
    {
        super("Rental Program");
        getContentPane().setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(5,1));

        connectButton  = new BigButton("Connect");
        connectButton.addActionListener(this);
        rentButton   = new BigButton("Rent...");
        rentButton.addActionListener(this);
        returnButton = new BigButton("Return...");
        returnButton.addActionListener(this);
        displayButton= new BigButton("Display...");
        displayButton.addActionListener(this);
        closeButton  = new BigButton("Close");
        closeButton.addActionListener(this);

        buttons.add(connectButton);
        buttons.add(rentButton);
        buttons.add(returnButton);
        buttons.add(displayButton);
        buttons.add(closeButton);

        infoArea = new InfoArea();

        getContentPane().add(buttons, BorderLayout.CENTER);
        getContentPane().add(infoArea,BorderLayout.SOUTH);

        enableDisableButtons(false);

        setSize(275,300);
        setLocation(200,300);

        closer = new FrameListener(this,true);
        addWindowListener(closer);

        setVisible(true); // now preferred over show()
    } // end ctor

    public static void main(String args[])
    {
        RentalGUI app = new RentalGUI();
    } // end main

    public void actionPerformed(ActionEvent evt)
    {
        Object srcObj = evt.getSource();
        if (srcObj == connectButton)
          {
            Thread thread = new Thread(this);
            runRequest = RUN_CONNECT;
            thread.start();
          }
        if (srcObj == rentButton)
          {
            RentWindow rentWindow = new RentWindow(this,ourDB);
            rentWindow.setVisible(true);
          }
        else if (srcObj == returnButton)
          {
            ReturnWindow returnWindow = new ReturnWindow(this,ourDB);
            returnWindow.setVisible(true);
          }
        else if (srcObj == displayButton)
          {
            DisplayWindow displayWindow = new DisplayWindow(this,ourDB);
            displayWindow.setVisible(true);
          }
        else if (srcObj == closeButton)
          {
            if (ourDB != null)
              ourDB.disConnect();
            closer.closeWindow();
          }
    }

    InfoArea getInfoArea()
    {
        return infoArea;
    }

    private void enableDisableButtons(boolean connected)
    {
        connectButton.setEnabled(!connected);
        rentButton.setEnabled(connected);
        returnButton.setEnabled(connected);
        displayButton.setEnabled(connected);
    }

    /**
     * For running in a method
     */
    public void run()
    {
        if (runRequest == RUN_CONNECT)
          {
            infoArea.setText("Registering jdbc driver...");
            // TODO: specify your system name, user id, password,
            //       and library here...
            String system = "";
            String userId = "";
            String passWord="";
            String library= "";
            String file=    "CARDB";
            // here we ensure you remembered to specify this info...
            if ((system==null) || (system.length()==0) ||
                (userId==null) || (userId.length()==0) ||
                (passWord==null) || (passWord.length()==0) ||
                (library==null) || (library.length()==0))
              {
                 infoArea.setText("Error: You haven't edited RentalGUI yet!");
                 return;
              }
            // Instantiate our helper class, RentalConnection...
            ourDB = new RentalConnection(system,library,file);
            infoArea.setText("Connecting...");
            // Connect to the database, using our RentalConnection helper class
            boolean connected = ourDB.connect(userId,passWord);
            if (connected)
              {
               infoArea.setText("Preparing...");
               connected = ourDB.prepare();
              }
            if (!connected)
              infoArea.setText("Error connecting: " + ourDB.getLastError());
            else
              infoArea.setText("Connected to " + ourDB.getSystem());
            enableDisableButtons(connected);
          }
    }
} // end RentalGUI
