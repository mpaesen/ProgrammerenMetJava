import javax.swing.*;
import java.awt.*;

public class CustomerGUI extends JDialog implements CommonButtonInterface
{
    private CommonButtons buttons;
    private FrameListener closer;
    private JTextField    lnameEntry;
    private JTextField    fnameEntry;
    private JTextField    phoneEntry;
    private JTextField    countryEntry;
    private JTextArea     addressEntry;

    private InfoArea infoArea;
    private boolean  createMode;
    private boolean  cancelled = true;

    private CustConnection ourDB;
    private Customer       cust;

    /**
     * Constructor
     */
    public CustomerGUI(JFrame parent, CustConnection ourDB, Customer cust, boolean createMode)
    {
        super(parent,true);
        this.ourDB = ourDB;
        this.cust  = cust;
        this.createMode = createMode;
        if (createMode)
          setTitle("Add New Customer");
        else
          setTitle("Change Customer");

        getContentPane().setLayout(new BorderLayout());
        // set some spacing between components and frame...
        ((JPanel)getContentPane()).setBorder(
           BorderFactory.createEmptyBorder(5,5,5,5));

        buttons = new CommonButtons(this);
        if (createMode)
          buttons.setOKButtonText("Create");
        else
          buttons.setOKButtonText("Change");
        infoArea = new InfoArea();
        JPanel bottomPanel = new JPanel(new GridLayout(2,1));
        bottomPanel.add(buttons);
        bottomPanel.add(infoArea);
        getContentPane().add(bottomPanel,BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(5,2));

        mainPanel.add(new JLabel("Last Name"));
        lnameEntry = new JTextField(20);
        mainPanel.add(lnameEntry);

        mainPanel.add(new JLabel("First Name"));
        fnameEntry = new JTextField(20);
        mainPanel.add(fnameEntry);

        mainPanel.add(new JLabel("Phone number"));
        phoneEntry = new JTextField(10);
        mainPanel.add(phoneEntry);

        mainPanel.add(new JLabel("Country"));
        countryEntry = new JTextField(20);
        mainPanel.add(countryEntry);

        centerPanel.add(mainPanel,BorderLayout.CENTER);

        JPanel addressPanel = new JPanel(new GridLayout(1,2));
        addressPanel.add(new JLabel("Address"));
        addressEntry = new JTextArea(5,20);
        addressPanel.add(new JScrollPane(addressEntry));
        centerPanel.add(addressPanel,BorderLayout.SOUTH);

        getContentPane().add(centerPanel,BorderLayout.CENTER);

        // initialize values...
        if (!createMode)
          {
            lnameEntry.setText(cust.getLName());
            fnameEntry.setText(cust.getFName());
            phoneEntry.setText(cust.getPhone());
            countryEntry.setText(cust.getCountry());
            addressEntry.setText(insertCRLF(cust.getAddress()));
          }

        closer = new FrameListener(this,false);
        addWindowListener(closer);

        setLocation(300,200);
        pack();
        lnameEntry.requestFocus();
    } // end ctor

    public boolean verifyInput()
    {
        boolean error = true;
        if (lnameEntry.getText().trim().length() == 0)
          lnameEntry.requestFocus();
        else if (fnameEntry.getText().trim().length() == 0)
          fnameEntry.requestFocus();
        else if (phoneEntry.getText().trim().length() == 0)
          phoneEntry.requestFocus();
        else if (countryEntry.getText().trim().length() == 0)
          countryEntry.requestFocus();
        else if (addressEntry.getText().trim().length() == 0)
          addressEntry.requestFocus();
        else
          error = false;
        if (error)
          infoArea.setText("Data required in all fields");
        return !error;
    } // end verifyInput

    public void okPressed()
    {
        if (!verifyInput())
          return;
        cancelled = false;
        cust.setLName(lnameEntry.getText().trim().toUpperCase());
        cust.setFName(fnameEntry.getText().trim().toUpperCase());
        cust.setPhone(phoneEntry.getText().trim());
        cust.setCountry(countryEntry.getText().trim().toUpperCase());
        cust.setAddress(stripCRLF(addressEntry.getText().trim().toUpperCase()));
        closer.closeWindow();
    } // end okPressed

    public void cancelPressed()
    {
        cancelled = true;
        closer.closeWindow();
    }

    public boolean dialogCancelled()
    {
        return cancelled;
    }

    private String stripCRLF(String input)
    {
        StringBuffer output = new StringBuffer(input.length());
        for (int idx=0; idx<input.length();idx++)
           if (input.charAt(idx)=='\n')
             output.append("  ");
           else if (input.charAt(idx)!='\r')
             output.append(input.charAt(idx));
         return output.toString();
    } // end stripCRLF

    private String insertCRLF(String input)
    {
        if (input.length() <= 1)
          return input;
        StringBuffer output = new StringBuffer(input.length());
        for (int idx=0; idx < input.length(); idx++)
           if ((idx < input.length()-1) &&
               (input.charAt(idx)==' ') &&
               (input.charAt(idx+1)==' '))
             {
               output.append("\r\n");
               idx++;
             }
           else
             output.append(input.charAt(idx));
         return output.toString();
    } // end insertCRLF

} // End CustomerGUI
