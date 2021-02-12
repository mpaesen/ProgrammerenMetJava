package ch13;

import com.ibm.as400.access.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

//import java.sql.*;

public class WWCustomers extends JFrame implements ActionListener, ListSelectionListener, Runnable {
    private JButton connectButton, closeButton;
    private JButton addButton, changeButton, deleteButton;
    private InfoArea infoArea;
    private FrameListener closer;
    private JList custList;
    private DefaultListModel listModel;
    private Thread thread;
    // private Statement stmt = null;
    private boolean stopList = false;
    private CustConnection ourDB;
    private int highestId = 111111;

    public WWCustomers() {
        super("Work With Customers");
        getContentPane().setLayout(new BorderLayout());
        JPanel buttons = new JPanel(new GridLayout(1, 2));
        connectButton = new JButton("Connect");
        closeButton = new JButton("Close");
        connectButton.setBorder(BorderFactory.createRaisedBevelBorder());
        closeButton.setBorder(BorderFactory.createRaisedBevelBorder());
        buttons.add(connectButton);
        buttons.add(closeButton);
        connectButton.addActionListener(this);
        closeButton.addActionListener(this);
        infoArea = new InfoArea();
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        listModel = new DefaultListModel();
        custList = new JList(listModel);
        custList.setFont(new Font("Courier", Font.PLAIN, 11));
        custList.addListSelectionListener(this);
        JPanel listButtons = new JPanel(new GridLayout(3, 1));
        addButton = createButton("New...", listButtons);
        changeButton = createButton("Change...", listButtons);
        deleteButton = createButton("Delete", listButtons);
        addButton.setEnabled(false);
        changeButton.setEnabled(false);
        deleteButton.setEnabled(false);
        JPanel clientPanel = new JPanel(new BorderLayout());
        clientPanel.add(new JScrollPane(custList), BorderLayout.CENTER);
        clientPanel.add(listButtons, BorderLayout.EAST);
        getContentPane().add(clientPanel, BorderLayout.CENTER);
        closer = new FrameListener(this, true);
        addWindowListener(closer);
        setLocation(200, 250);
        setSize(650, 250);
        setVisible(true);
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

    public void run() {
        listCusts();
    }

    private void listCusts() {
        //        ResultSet rs = null;
        //        int custID;
        Integer custID;
        String custLName;
        String custFName;
        String custPhone;
        String custCountry;
        String custAddress;
        int count = 0;
        //DDM
        Record currRecord;
        //DDM
        enableDisableButtonsForThread(true);
        custList.removeAll();
        listModel.clear();
        //        String sqlQuery = "Select * from " + ourDB.getLibFile();
        try {
            infoArea.setText("Performing execute query...");
            //DDM
            ourDB.getSeqFile().positionCursorToFirst();
            currRecord = ourDB.getSeqFile().read();
            //DDM

	/*      stmt = ourDB.getConnection().createStatement();
            if (!stopList)
                rs = stmt.executeQuery(sqlQuery);
            infoArea.setText("Querying result set...");
            while (!stopList && rs.next())
    */

            while (!stopList && (currRecord != null)) {
      /*          custID = rs.getInt("CUSTID");
                highestId = custID;
                custLName = rs.getString("LNAME").trim();
                custFName = rs.getString("FNAME").trim();
                custPhone = rs.getString("PHONE").trim();
                custCountry = rs.getString("COUNTRY").trim();
                custAddress = rs.getString("ADDRESS").trim();
	*/

                //DDM
                custID = (Integer)currRecord.getField(0);
                highestId = custID.intValue();
                custLName = (String)currRecord.getField(1);
                custFName = (String)currRecord.getField(2);
                custPhone = (String)currRecord.getField(3);
                custCountry = (String)currRecord.getField(4);
                custAddress = (String)currRecord.getField(5);
                //DDM
                listModel.addElement(custID + " " + custLName + " " + custFName + " " + custPhone + " " +
                    custCountry + " " + custAddress);
                count++;
                infoArea.setText("Rows so far: " + count);
                //DDM
                currRecord = ourDB.getSeqFile().readNext();
                //DDM
            }

            /*
            rs.close();
            stmt.close();
            stmt = null;
            */

            if (!stopList)
                infoArea.setText("Database query done. Total rows: " + count);
            else
                infoArea.setText("Database query cancelled at row: " + count);
        }
        catch (Exception exc) {
            //catch (SQLException exc) {
            infoArea.setText("Unexpected Error: " + exc.getMessage());
        }
        enableDisableButtonsForThread(false);
    } // end listCusts

    private int getSelectedItemID() {
        String selItem = (String)custList.getSelectedValue();
        StringTokenizer tokens = new StringTokenizer(selItem);
        String custIdString = tokens.nextToken();
        int custId = -1;
        try {
            custId = Integer.parseInt(custIdString);
        } catch (NumberFormatException exc) { }
        return custId;
    }

    public void actionPerformed(ActionEvent evt) {
        JButton button = (JButton)evt.getSource();
        if (button == connectButton) {
            infoArea.setText("Registering jdbc driver...");
            // TODO: specify your system name, user id, password,
            //       and library here...
            String system = "ASEDUC";
            String userId = "INSTRUCTOR";
            String passWord = "INSTRUCTOR";
            String library = "PAMA";
            String file = "CUSTDB";
            // here we ensure you remembered to specify this info...
            if ((system == null) || (system.length() == 0) || (userId == null) || (userId.length() == 0) ||
                (passWord == null) || (passWord.length() == 0) || (library == null) || (library.length() == 0)) {
                    infoArea.setText("Error: You haven't editing wwCustomers yet");
                    return;
            }
            // Instantiate our helper class, RentalConnection...
            ourDB = new CustConnection(system, library, file);
            infoArea.setText("Connecting...");
            boolean connected = ourDB.connect(userId, passWord);
            if (!connected)
                infoArea.setText("Connect failed: " + ourDB.getLastError());
            else {
                infoArea.setText("Connected to " + ourDB.getSystem());
                thread = new Thread(this);
                thread.start();
            }
            connectButton.setEnabled(!connected);
            addButton.setEnabled(connected);
        }
        else if (button == closeButton) {
            if (thread != null)
                thread.stop();
            if (ourDB != null)
                ourDB.disConnect();
            closer.closeWindow();
        }
        else if (button == addButton) {
            Customer cust = new Customer(ourDB);
            CustomerGUI addWindow = new CustomerGUI(this, ourDB, cust, true);
            addWindow.setVisible(true);
            if (!addWindow.dialogCancelled()) {
                cust.setID(++highestId);
                infoArea.setText("Adding customer...");
                if (cust.insert()) {
                    if (thread != null)
                        thread.stop();
                    thread = new Thread(this);
                    thread.start();
                    infoArea.setText("Customer " + cust.getID() + " added.");
                }
                else {
                    infoArea.setText("Add failed: " + ourDB.getLastError());
                }
            } // end if addWindow not cancelled
        } // end if addButton
        else if (button == changeButton) {
            int custId = getSelectedItemID();
            Customer cust = new Customer(ourDB);
            infoArea.setText("Reading data for customer " + custId + "...");
            if (!cust.read(custId)) {
                infoArea.setText("Read failed: " + ourDB.getLastError());
                return;
            }
            infoArea.setText("");
            CustomerGUI chgWindow = new CustomerGUI(this, ourDB, cust, false);
            chgWindow.setVisible(true);
            if (!chgWindow.dialogCancelled()) {
                infoArea.setText("Updating customer...");
                if (cust.update()) {
                    if (thread != null)
                        thread.stop();
                    thread = new Thread(this);
                    thread.start();
                    infoArea.setText("Customer " + cust.getID() + " updated.");
                }
                else {
                    infoArea.setText("Update failed: " + ourDB.getLastError());
                }
            } // end if chgWindow not cancelled
        } // end if cancelButton
        else if (button == deleteButton) {
            int custId = getSelectedItemID();
            Customer cust = new Customer(ourDB);
            infoArea.setText("Deleting customer...");
            if (cust.delete(custId)) {
                if (thread != null)
                    thread.stop();
                thread = new Thread(this);
                thread.start();
                infoArea.setText("Customer " + cust.getID() + " deleted.");
            }
            else {
                infoArea.setText("Delete failed: " + ourDB.getLastError());
            }
        } // end if deleteButton
    } // end actionPerformed

    public void valueChanged(ListSelectionEvent evt) {
        Object obj = evt.getSource();
        if (obj == custList) {
            boolean selected = (custList.getSelectedIndex() != -1);
            changeButton.setEnabled(selected);
            deleteButton.setEnabled(selected);
        }
    }

    private void enableDisableButtonsForThread(boolean running) {
        addButton.setEnabled(!running);
        if (running) {
            changeButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
    }

    public static void main(String args[]) {
        WWCustomers me = new WWCustomers();
    }
} // end WWCustomers class
