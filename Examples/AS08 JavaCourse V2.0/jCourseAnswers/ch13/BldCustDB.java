import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BldCustDB extends JFrame implements ActionListener
{
    private static String FILENAME = "CUSTDB";
    private Connection conn;
    private Statement  stmt;
    private FrameListener closer;
    private JButton connectButton, disConnectButton, buildButton, cancelButton;
    private InfoArea   infoArea;
    private JLabel     sysLabel;
    private JTextField sysEntry;
    private JLabel     libLabel;
    private JTextField libEntry;
    private JLabel     fileLabel;
    private JTextField fileEntry;
    private String     libfile;

    public BldCustDB()
    {
        super("Build AS/400 Customer Database");
        getContentPane().setLayout(new BorderLayout());

        JPanel clientPanel = new JPanel(new GridLayout(3,2));
        sysLabel  = new JLabel("System name or tcp/ip address");
        sysEntry  = new JTextField(10);
        libLabel  = new JLabel("Library");
        libEntry  = new JTextField(10);
        fileLabel = new JLabel("File");
        fileEntry = new JTextField(10);
        fileEntry.setText(FILENAME);
        clientPanel.add(sysLabel);
        clientPanel.add(sysEntry);
        clientPanel.add(libLabel);
        clientPanel.add(libEntry);
        clientPanel.add(fileLabel);
        clientPanel.add(fileEntry);
        getContentPane().add(clientPanel,BorderLayout.CENTER);

        JPanel buttons = new JPanel(new GridLayout(1,4));
        connectButton    = createButton("Connect",buttons);
        disConnectButton = createButton("Disconnect",buttons);
        buildButton      = createButton("Build DB",buttons);
        cancelButton     = createButton("Cancel",buttons);
        disConnectButton.setEnabled(false);
        buildButton     .setEnabled(false);

        infoArea = new InfoArea();

        JPanel bottomPanel = new JPanel(new GridLayout(2,1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);

        getContentPane().add(bottomPanel,BorderLayout.SOUTH);

        closer = new FrameListener(this,true);
        addWindowListener(closer);

        setLocation(300,200);
        pack();
        setVisible(true);
    }

    /**
     * Helper method for creating a JButton with the given label,
     * setting its border, registering we want to listen for pressed
     * events, and adding it to the given JPanel
     */
    private JButton createButton(String label, JPanel buttonPanel)
    {
        JButton newButton = new JButton(label);
        newButton.setBorder(BorderFactory.createRaisedBevelBorder());
        newButton.addActionListener(this);
        buttonPanel.add(newButton);
        return newButton;
    }

    /**
     * Helper method for connecting to a given AS/400 system
     */
    private boolean connect(String system)
    {
        boolean ok = false;
        // register the jdbc for db2400 driver
        try
        {
           infoArea.setText("Registering JDBC400 driver...");
           DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());
           infoArea.setText("Driver registered.");
        }
        catch (SQLException exc)
        {
           infoArea.setText("Driver register failed: " + exc.getMessage());
           return false;
        }
        // make the connection. Create statement object
        try
        {
           infoArea.setText("Connecting to "+system+"...");
           conn = DriverManager.getConnection("jdbc:as400://"+system+";naming=system");
           stmt = conn.createStatement();
           infoArea.setText("Connected to "+system+".");
           ok = true;
        }
        catch (SQLException exc)
        {
           infoArea.setText("Connect to "+system+" failed: " + exc.getMessage());
           conn = null; // to be sure
        }
        requestFocus();
        libEntry.requestFocus();
        return ok;
    } // end connect

    private void disConnect()
    {
       if (conn!=null)
         {
            try {
              conn.close();
            } catch(SQLException exc) {}
            connectButton.setEnabled(true);
            disConnectButton.setEnabled(false);
            buildButton.setEnabled(false);
            conn=null; // only do this once
         }
    } // end disConnect

    public boolean buildDB()
    {
        boolean ok = false;
        infoArea.setText("Creating database file " + libfile + "...");
        try
        {
           String createStmt = "CREATE TABLE " + libfile + "( ";
           createStmt += "CUSTID INTEGER NOT NULL, ";
           createStmt += "LNAME CHAR(30) NOT NULL, ";
           createStmt += "FNAME CHAR(30) NOT NULL, ";
           createStmt += "PHONE CHAR(10) NOT NULL, ";
           createStmt += "COUNTRY CHAR(20) NOT NULL, ";
           createStmt += "ADDRESS CHAR(100) NOT NULL, ";
           createStmt += "PRIMARY KEY(CUSTID) ";
           createStmt += ")";
           System.out.println(createStmt);
           int rc = stmt.executeUpdate(createStmt);
           System.out.println("Return code from CREATE TABLE: " + rc);
           infoArea.setText("Database file " + libfile + "created. RC = "+rc);
           stmt.close();
           ok = true;
        }
        catch (SQLException exc)
        {
           // SQL7905 is informational only, so it's ok...
           int errcode = exc.getErrorCode();
           if (errcode == 7905)
             {
               infoArea.setText("Database file " + libfile + " created.");
               //stmt.close();
               ok = true;
             }
           else
             {
               infoArea.setText("Create file " + libfile + " failed: " + exc.getMessage());
             }
        }
        return ok;
    }

    public void actionPerformed(ActionEvent evt)
    {
        Object obj = evt.getSource();
        if (obj == cancelButton)
          {
            disConnect();
            closer.closeWindow();
          }
        else if (obj == connectButton)
          {
            String sys = sysEntry.getText().trim();
            if (sys.length() == 0)
              {
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
          }
        else if (obj == disConnectButton)
          {
            disConnect();
          }
        else if (obj == buildButton)
          {
            if (!getLibFile())
              return;
            boolean ok = buildDB();
          }
    } // end actionPerformed

    private boolean getLibFile()
    {

        String lib = libEntry.getText().trim();
        if (lib.length() == 0)
          {
             infoArea.setText("Library name required");
             libEntry.requestFocus();
             return false;
          }
        lib = lib.toUpperCase();
        libEntry.setText(lib);
        String file = fileEntry.getText().trim();
        if (file.length() == 0)
          {
             infoArea.setText("File name required");
             fileEntry.requestFocus();
             return false;
          }
        file = file.toUpperCase();
        fileEntry.setText(file);
        libfile = lib+"/"+file;
        return true;
    } // getLibFile

    public static void main(String arg[])
    {
        BldCustDB me = new BldCustDB();
    }
}
