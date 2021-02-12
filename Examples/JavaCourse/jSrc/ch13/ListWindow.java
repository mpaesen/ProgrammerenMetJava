package jSrc.ch13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ListWindow extends JDialog implements
                                 ActionListener, Runnable
{
    private JButton       okButton;
    private JButton       cancelButton;
    private InfoArea      infoArea;
    private FrameListener closer;
    private JList         carList;
    private Connection    conn;
    private String        file;
    private Thread        thread;
    private Statement     stmt=null;
    private boolean       stopList=false;

    public ListWindow(JFrame parent, Connection conn, String file)
    {
        super(parent, "Display All Cars", true);
        this.conn = conn;
        this.file = file;

        getContentPane().setLayout(new BorderLayout());

        JPanel buttons = new JPanel(new GridLayout(1,2));
        okButton     = createButton("Close",buttons);
        cancelButton = createButton("Stop",buttons);

        infoArea = new InfoArea();

        JPanel bottomPanel = new JPanel(new GridLayout(2,1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        getContentPane().add(bottomPanel,BorderLayout.SOUTH);

        carList = new JList(new DefaultListModel());
        carList.setFont(new Font("Courier",Font.PLAIN,10));
        //carList.setVisibleRowCount(12);
        getContentPane().add(new JScrollPane(carList),BorderLayout.CENTER);

        closer = new FrameListener(this,false);
        addWindowListener(closer);
        setLocation(200,250);
        setSize(600,250);
        //pack();
        try {
         stmt = conn.createStatement();
        } catch (SQLException exc) {}
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }

    private JButton createButton(String label, JPanel buttonPanel)
    {
        JButton newButton = new JButton(label);
        newButton.setBorder(BorderFactory.createRaisedBevelBorder());
        newButton.addActionListener(this);
        buttonPanel.add(newButton);
        return newButton;
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

       okButton.setEnabled(false);
       try
       {
          infoArea.setText("Performing execute query...");
          conn.setReadOnly(true);
          if (!stopList)
            rs = stmt.executeQuery("SELECT * FROM " + file);
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
               carStatusString = " Rented";
             if (carRentDateNull)
               carRentDateString = "  Null-rent-date";
             else
               carRentDateString = "  " + carRentDate.toString();
             if (carReturnDateNull)
               carReturnDateString = "  Null-return-date";
             else
               carReturnDateString = "  " + carReturnDate.toString();
             ((DefaultListModel)(carList.getModel())).addElement(
                carPlate + " " + carClass + " " + carMake + " " +
                carColor + carStatusString+
                carRentDateString + carReturnDateString);
             count++;
             if ((count % 10) == 0)
               infoArea.setText("Rows so far: " + count);
          }
          stmt.close();
          if (!stopList)
            infoArea.setText("Database query done. Total rows: " + count);
          else
            infoArea.setText("Database query cancelled at row: " + count);
       }
       catch (SQLException exc)
       {
          infoArea.setText("Unexpected Error: "+exc.getMessage());
       }
       okButton.setEnabled(true);
       cancelButton.setEnabled(false);
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
        else if (button == cancelButton)
          {
             stopList = true;
             if (stmt != null)
               try {
                 stmt.cancel();
               } catch (SQLException exc) {}
             cancelButton.setEnabled(false);
          }
    } // end actionPerformed


} // end ListWindow class
