package jSrc.ch13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class DisplayWindow extends JDialog implements
                           ActionListener, Runnable
{
    private JButton       okButton, listButton, cancelButton;
    private JRadioButton  rentedRB, notRentedRB, allRB;
    private ButtonGroup   bg;
    private InfoArea      infoArea;
    private FrameListener closer;
    private JList         carList;
    private DefaultListModel listModel;
    private Thread        thread;
    private Statement     stmt=null;
    private boolean       stopList=false;
    private RentalConnection ourDB;

    public DisplayWindow(JFrame parent, RentalConnection ourDB)
    {
        super(parent, "Display Cars", true);
        this.ourDB = ourDB;

        getContentPane().setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1,3));
        okButton     = new JButton("Close");
        listButton   = new JButton("List");
        cancelButton = new JButton("Stop");
        okButton.setBorder(BorderFactory.createRaisedBevelBorder());
        listButton.setBorder(BorderFactory.createRaisedBevelBorder());
        cancelButton.setBorder(BorderFactory.createRaisedBevelBorder());
        cancelButton.setEnabled(false);
        buttons.add(okButton);
        buttons.add(listButton);
        buttons.add(cancelButton);
        okButton.addActionListener(this);
        listButton.addActionListener(this);
        cancelButton.addActionListener(this);

        infoArea = new InfoArea();

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2,1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        getContentPane().add(bottomPanel,BorderLayout.SOUTH);

        listModel = new DefaultListModel();
        carList = new JList(listModel);
        carList.setFont(new Font("Courier",Font.PLAIN,11));
        carList.setVisibleRowCount(10);
        bg = new ButtonGroup();
        rentedRB    = new JRadioButton("Rented",true);
        notRentedRB = new JRadioButton("Not rented");
        allRB       = new JRadioButton("All");
        bg.add(rentedRB);
        bg.add(notRentedRB);
        bg.add(allRB);
        JPanel rbPanel = new JPanel(new GridLayout(1,3));
        rbPanel.add(allRB);
        rbPanel.add(rentedRB);
        rbPanel.add(notRentedRB);
        JPanel clientPanel = new JPanel(new BorderLayout());
        clientPanel.add(new JScrollPane(carList),BorderLayout.CENTER);
        clientPanel.add(rbPanel,BorderLayout.SOUTH);
        getContentPane().add(clientPanel,BorderLayout.CENTER);

        closer = new FrameListener(this,false);
        addWindowListener(closer);
        setLocation(200,250);
        setSize(620,250);
    }

    public void run()
    {
        listCars();
    }

    private void listCars()
    {
       ResultSet rs=null;
       String    carPlate;
       String    carClass;
       String    carMake;
       String    carColor;
       String    carStatus;
       Timestamp carRentDate;
       Timestamp carReturnDate;
       boolean   carRentDateNull;
       boolean   carReturnDateNull;
       String    carStatusString;
       String    carRentDateString;
       String    carReturnDateString;
       int       count=0;

       enableDisableButtonsForThread(true);
       listModel.removeAllElements();
       String sqlQuery = "SELECT * FROM " + ourDB.getLibFile();
       try
       {
          infoArea.setText("Performing execute query...");
          stmt = ourDB.getConnection().createStatement();
          if (rentedRB.isSelected())
            sqlQuery += " WHERE STATUS = 'R'";
          else if (notRentedRB.isSelected())
            sqlQuery += " WHERE STATUS = 'N'";
          if (!stopList)
            rs = stmt.executeQuery(sqlQuery);
          infoArea.setText("Querying result set...");
          while ( !stopList && rs.next() )
          {
             carPlate = rs.getString(1);
             carClass = rs.getString(2);
             carMake  = rs.getString(3);
             carColor = rs.getString(4);
             carStatus= rs.getString(5);
             carRentDate = rs.getTimestamp(6);
             carRentDateNull = rs.wasNull();
             carReturnDate = rs.getTimestamp(7);
             carReturnDateNull = rs.wasNull();
             //System.out.println("Car status = '" + carStatus + "'");
             if (carStatus.equals("N"))
               carStatusString = " Not-rented";
             else
               carStatusString = " Rented    ";
             if (carRentDateNull)
               carRentDateString = Car.padString("  Null-rent-date",26);
             else
               carRentDateString = Car.padString("  " + carRentDate.toString(),26);
             if (carReturnDateNull)
               carReturnDateString = Car.padString("  Null-return-date",26);
             else
               carReturnDateString = Car.padString("  " + carReturnDate.toString(),26);
             listModel.addElement(carPlate + " " + carClass + " " + carMake + " " +
                                  carColor + carStatusString+
                                  carRentDateString + carReturnDateString);
             count++;
             if ((count%10)==0)
               infoArea.setText("Rows so far: " + count);
          }
          rs.close();
          stmt.close();
          stmt = null;
          if (!stopList)
            infoArea.setText("Database query done. Total rows: " + count);
          else
            infoArea.setText("Database query cancelled at row: " + count);
       }
       catch (SQLException exc)
       {
          infoArea.setText("Unexpected Error: "+exc.getMessage());
       }
       enableDisableButtonsForThread(false);
    } // end listCars

    public void actionPerformed(ActionEvent evt)
    {
        JButton button = (JButton)evt.getSource();
        if (button == okButton)
          {
             if (stmt != null)
               try {
                 stmt.cancel();
               } catch (SQLException exc) {}
             if (thread != null)
               thread.stop();
             closer.closeWindow();
          }
        else if (button == listButton)
          {
             if (thread != null)
               thread.stop();
             thread = new Thread(this);
             thread.setPriority(Thread.MIN_PRIORITY);
             thread.start();
          }
        else if (button == cancelButton)
          {
             stopList = true;
             if (stmt != null)
               try {
                 stmt.cancel();
               } catch (SQLException exc) {}
             enableDisableButtonsForThread(false);
          }
    } // end actionPerformed

    private void enableDisableButtonsForThread(boolean running)
    {
        okButton.setEnabled(!running);
        listButton.setEnabled(!running);
        cancelButton.setEnabled(running);
        allRB.setEnabled(!running);
        rentedRB.setEnabled(!running);
        notRentedRB.setEnabled(!running);
    }
} // end DisplayWindow class
