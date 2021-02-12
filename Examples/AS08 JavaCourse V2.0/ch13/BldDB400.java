package ch13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class BldDB400 extends JFrame implements ActionListener, Runnable {
    private static String FILENAME = "CARDB";
    private static final String makes[] = {"Ford","GM","Chrysler","Toyota","Nissan","Honda","Volkswagen"};
    private static final String classes[] = {"Economy","Midsize","Luxury"};
    private static final String colors[] = {"Blue","Red","Green","Purple","Pearl","Grey","Silver","White","Black"};
    private Connection conn;
    private Statement stmt;
    private FrameListener closer;
    private JButton connectButton, disConnectButton, buildButton, listButton, cancelButton;
    private InfoArea infoArea;
    private JLabel sysLabel;
    private JTextField sysEntry;
    private JLabel libLabel;
    private JTextField libEntry;
    private JLabel fileLabel;
    private JTextField fileEntry;
    private String libfile;
    private Thread thread;

    public BldDB400() {
        super("Build AS/400 Car Database");
        getContentPane().setLayout(new BorderLayout());
        JPanel clientPanel = new JPanel(new GridLayout(3, 2));
        sysLabel = new JLabel("System name or tcp/ip address  ");
        sysEntry = new JTextField(10);
        libLabel = new JLabel("Library");
        libEntry = new JTextField(10);
        fileLabel = new JLabel("File");
        fileEntry = new JTextField(10);
        fileEntry.setText(FILENAME);
        clientPanel.add(sysLabel);
        clientPanel.add(sysEntry);
        clientPanel.add(libLabel);
        clientPanel.add(libEntry);
        clientPanel.add(fileLabel);
        clientPanel.add(fileEntry);
        getContentPane().add(clientPanel, BorderLayout.CENTER);
        JPanel buttons = new JPanel(new GridLayout(1, 5));
        connectButton = createButton("Connect", buttons);
        disConnectButton = createButton("Disconnect", buttons);
        buildButton = createButton("Build DB", buttons);
        listButton = createButton("List DB", buttons);
        cancelButton = createButton("Cancel", buttons);
        disConnectButton.setEnabled(false);
        buildButton.setEnabled(false);
        listButton.setEnabled(false);
        infoArea = new InfoArea();
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        closer = new FrameListener(this, true);
        addWindowListener(closer);
        setLocation(300, 200);
        pack();
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

    /** Helper method for connecting to a given AS/400 system */
    private boolean connect(String system) {
        boolean ok = false;
        // register the jdbc for db2400 driver
        try {
            infoArea.setText("Registering JDBC400 driver...");
            DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());
            infoArea.setText("Driver registered.");
        }
        catch (SQLException exc) {
            infoArea.setText("Driver register failed: " + exc.getMessage());
            return false;
        }
        // make the connection. Create statement object
        try {
            infoArea.setText("Connecting to " + system + "...");
            conn = DriverManager.getConnection("jdbc:as400://" + system + ";naming=system");
            stmt = conn.createStatement();
            infoArea.setText("Connected to " + system + ".");
            ok = true;
        }
        catch (SQLException exc) {
            infoArea.setText("Connect to " + system + " failed: " + exc.getMessage());
            conn = null; // to be sure
        }
        requestFocus();
        libEntry.requestFocus();
        return ok;
    } // end connect

    private void disConnect() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException exc) { }
            connectButton.setEnabled(true);
            disConnectButton.setEnabled(false);
            buildButton.setEnabled(false);
            listButton.setEnabled(false);
            conn = null; // only do this once
        }
    } // end disConnect

    public boolean buildDB() {
        boolean ok = false;
        infoArea.setText("Creating database file " + libfile + "...");
        try {
            String createStmt = "CREATE TABLE " + libfile + "( ";
            createStmt += "PLATE CHAR(10) NOT NULL, ";
            createStmt += "CLASS CHAR(10) NOT NULL, ";
            createStmt += "MAKE  CHAR(10) NOT NULL, ";
            createStmt += "COLOR CHAR(10) NOT NULL, ";
            createStmt += "STATUS CHAR(1) NOT NULL, ";
            createStmt += "RENTDATE TIMESTAMP DEFAULT NULL, ";
            createStmt += "RETDATE TIMESTAMP DEFAULT NULL, ";
            createStmt += "PRIMARY KEY(PLATE) ";
            createStmt += ")";
            System.out.println(createStmt);
            int rc = stmt.executeUpdate(createStmt);
            System.out.println("Return code from CREATE TABLE: " + rc);
            infoArea.setText("Database file " + libfile + "created. RC = " + rc);
            stmt.close();
            ok = true;
        }
        catch (SQLException exc) {
            // SQL7905 is informational only, so it's ok...
            int errcode = exc.getErrorCode();
            if (errcode == 7905) {
                infoArea.setText("Database file " + libfile + "created.");
                //stmt.close();
                ok = true;
            }
            else {
                infoArea.setText("Create file " + libfile + " failed: " + exc.getMessage());
            }
        }
        return ok;
    }

    public void run() {
        disConnectButton.setEnabled(false);
        buildButton.setEnabled(false);
        boolean ok = populateDB(1000);
        disConnectButton.setEnabled(true);
        buildButton.setEnabled(!ok);
        listButton.setEnabled(ok);
    }

    public boolean populateDB(int count) {
        boolean ok = false;
        PreparedStatement pstmt = null;
        infoArea.setText("Preparing statement for database file " + libfile + "...");
        try {
            String prepareStmt = "INSERT INTO " + libfile + " VALUES( ";
            prepareStmt += "?, ?, ?, ?, ?, NULL, NULL )";
            System.out.println(prepareStmt);
            pstmt = conn.prepareStatement(prepareStmt);
        }
        catch (SQLException exc) {
            infoArea.setText("Preparing statement failed with: " + exc.getMessage());
            return false;
        }
        infoArea.setText("Populating database file " + libfile + "...");
        String theMake;
        String thePlate;
        String theClass;
        String theColor;
        Random random = new Random();
        int nextRandom;
        int valInserts = 0;
        try {
            for (int idx = 0; idx < count; idx++) {
                nextRandom = Math.abs(random.nextInt());
                thePlate = makeXXDigits(nextRandom, 6);
                theClass = classes[nextRandom % classes.length];
                theMake = makes[nextRandom % makes.length];
                theColor = colors[nextRandom % colors.length];
                pstmt.setString(1, thePlate);
                pstmt.setString(2, theClass);
                pstmt.setString(3, theMake);
                pstmt.setString(4, theColor);
                pstmt.setString(5, "N");
                infoArea.setText("Inserting record " + (idx + 1) + "...");
                // our random number generator may generate a
                // duplicate key (plate) number. Thus, we will just
                // ignore that error and let the record not be added...
                try {
                    pstmt.executeUpdate();
                    valInserts++;
                } catch (SQLException exc) {
                    if (exc.getErrorCode() != -803) {
                        System.out.println("Error inserting. Error code =  " + exc.getErrorCode());
                        throw(exc);
                    }
                    else
                        System.out.println("FYI: duplicate key attempt on plate number " + thePlate);
                } // end catch
            } // end for loop
            ok = true;
            pstmt.close();
            infoArea.setText("File " + libfile + " populated! Valid inserts: " + valInserts);
        }
        catch (SQLException exc) {
            infoArea.setText("Populating file failed: " + exc.getMessage());
        }
        return ok;
    } // end populateDB

    private String makeXXDigits(int value, int digits) {
        Integer intobj = new Integer(value);
        String intString = intobj.toString();
        int len = intString.length();
        if (len > digits)
            intString = intString.substring(0, digits);
        else if (len < digits) {
            int delta = digits - len;
            for (int idx = 0; idx < delta; idx++)
                intString += "0";
        }
        return intString;
    } // end makeXXDigits

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();
        if (obj == cancelButton) {
            if (thread != null)
                thread.stop();
            disConnect();
            closer.closeWindow();
        }
        else if (obj == connectButton) {
            String sys = sysEntry.getText().trim();
            if (sys.length() == 0) {
                infoArea.setText("System name required");
                sysEntry.requestFocus();
                return;
            }
            sys = sys.toUpperCase();
            sysEntry.setText(sys);
            boolean connected = connect(sys);
            connectButton.setEnabled(!connected);
            disConnectButton.setEnabled(connected);
            buildButton.setEnabled(connected);
            listButton.setEnabled(connected);
        }
        else if (obj == disConnectButton) {
            disConnect();
        }
        else if (obj == buildButton) {
            if (!getLibFile())
                return;
            boolean ok = buildDB();
            if (ok) {
                thread = new Thread(this);
                thread.start();
            }
        }
        else if (obj == listButton) {
            if (!getLibFile())
                return;
            ListWindow listDlg = new ListWindow(this, conn, libfile);
            listDlg.setVisible(true);
        }
    } // end actionPerformed

    private boolean getLibFile() {
        String lib = libEntry.getText().trim();
        if (lib.length() == 0) {
            infoArea.setText("Library name required");
            libEntry.requestFocus();
            return false;
        }
        lib = lib.toUpperCase();
        libEntry.setText(lib);
        String file = fileEntry.getText().trim();
        if (file.length() == 0) {
            infoArea.setText("File name required");
            fileEntry.requestFocus();
            return false;
        }
        file = file.toUpperCase();
        fileEntry.setText(file);
        libfile = lib + "/" + file;
        return true;
    } // getLibFile

    public static void main(String arg[]) {
        BldDB400 me = new BldDB400();
    }
}
