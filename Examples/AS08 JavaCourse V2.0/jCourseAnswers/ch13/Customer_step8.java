import com.ibm.as400.access.*;

//import java.sql.*;

/**
 *  Represents a car in a car rental lot
 */
public class Customer
{
    // private instance variables...
    private CustConnection ourDB;
    // Variables matching fields in database record...
    private int    custID   =-1;
    private String custLName=null;
    private String custFName=null;
    private String custPhone=null;
    private String custCountry=null;
    private String custAddress=null;
    private Record currRecord=null;

    /**
     * Constructor
     */
    public Customer(CustConnection ourDB)
    {
        this.ourDB = ourDB;
    } // end ctor

    /**
     * Initialize just the ID (key field), and read this
     * entry from the database, populating the fields
     */
    public boolean read(int id)
    {
        custID = id;
        boolean ok = false;
        Object[] keyField = new Object[1];
        keyField[0] = new Integer(id);
        try
        {
           currRecord = ourDB.getKeyedFile().read(keyField);
           if (currRecord != null)
             {
                custLName = (String)currRecord.getField(1);
                custFName = (String)currRecord.getField(2);
                custPhone = (String)currRecord.getField(3);
                custCountry=(String)currRecord.getField(4);
                custAddress=(String)currRecord.getField(5);
                ok = true;
             }
        } // end try
        catch (Exception exc)
        {
           System.out.println("In Customer.read, Exception: " +
                              exc.getMessage());
           ourDB.setLastError(exc.getMessage());
        }
        return ok;
    } // end of read

    /**
     * Assuming all fields are initialized, this
     * method updates this entry in the database
     */
    public boolean update()
    {
        boolean ok = false;
        try
        {
          currRecord.setField(0, new Integer(custID));
          currRecord.setField(1, custLName);
          currRecord.setField(2, custFName);
          currRecord.setField(3, custPhone);
          currRecord.setField(4, custCountry);
          currRecord.setField(5, custAddress);

          ourDB.getKeyedFile().update(currRecord);

          ok = true;
        } // end try
        catch (Exception exc)
        {
           System.out.println("In Customer.update, Exception: " + exc.getMessage());
           ourDB.setLastError(exc.getMessage());
        }
        return ok;
    } // end of update

    /**
     * Assuming all fields are initialized, this
     * method inserts this entry in the database
     */
    public boolean insert()
    {
        boolean ok = false;
        RecordFormat rf = ourDB.getKeyedFile().getRecordFormat();
        currRecord = rf.getNewRecord();
        try
        {
          currRecord.setField(0, new Integer(custID));
          currRecord.setField(1, custLName);
          currRecord.setField(2, custFName);
          currRecord.setField(3, custPhone);
          currRecord.setField(4, custCountry);
          currRecord.setField(5, custAddress);

          ourDB.getKeyedFile().write(currRecord);

          ok = true;
        } // end try
        catch (Exception exc)
        {
           System.out.println("In Customer.insert, Exception: " + exc.getMessage());
           ourDB.setLastError(exc.getMessage());
        }
        return ok;
    } // end of insert

    /**
     * Given the customer ID, deletes this entry
     * from the database
     */
    public boolean delete(int ID)
    {
        custID = ID;
        boolean ok = false;
        try
        {
          Object[] keyField = new Object[1];
          keyField[0] = new Integer(custID);

          ourDB.getKeyedFile().deleteRecord(keyField);

          ok = true;
        } // end try
        catch (Exception exc)
        {
           System.out.println("In Customer.delete, Exception: " + exc.getMessage());
           ourDB.setLastError(exc.getMessage());
        }
        return ok;
    } // end of delete

    public String getDisplayInfo()
    {
        String display = "Customer ID: " + custID;
        display += " lname: " + custLName;
        display += " fname: " + custFName;
        display += " phone: " + custPhone;
        display += " country:" + custCountry;
        display += " address:" + custAddress;
        return display;
    }

    public int getID()
    {
        return custID;
    }

    public String getLName()
    {
        return custLName;
    }

    public String getFName()
    {
        return custFName;
    }

    public String getPhone()
    {
        return custPhone;
    }

    public String getCountry()
    {
        return custCountry;
    }

    public String getAddress()
    {
        return custAddress;
    }

    public void setID(int id)
    {
        custID = id;
    }

    public void setLName(String lname)
    {
        custLName = lname;
    }

    public void setFName(String fname)
    {
        custFName = fname;
    }

    public void setPhone(String phone)
    {
        custPhone = phone;
    }

    public void setCountry(String country)
    {
        custCountry = country;
    }

    public void setAddress(String address)
    {
        custAddress = address;
    }

    public static final String padString(String padString, int finalLen)
    {
        StringBuffer temp = new StringBuffer(padString);
        int curLen = padString.length();
        int padAmount = finalLen - curLen;
        for (int idx=0; idx<padAmount; idx++)
           temp.append(' ');
        return temp.toString();
    }

} // end of class Customer
