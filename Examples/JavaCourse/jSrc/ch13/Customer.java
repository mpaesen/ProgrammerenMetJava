package jSrc.ch13;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        try
        {
          Statement readStmt = ourDB.getConnection().createStatement();
          String    sql      = ??
          System.out.println("Read SQL statement: " + sql);
          ResultSet rs = readStmt.executeQuery(sql);
          if (rs.next())
            {
               custLName = ??
               custFName = ??
               custPhone = ??
               custCountry=??
               custAddress=??
               ok = true;
            }
          rs.close();
          readStmt.close();
        } // end try
        catch (SQLException exc)
        {
           System.out.println("In Customer.read, SQLException: " + exc.getMessage());
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
          Statement updStmt = ourDB.getConnection().createStatement();
          String    sql     = "UPDATE "+ourDB.getLibFile()+
                              " SET LNAME='" + custLName +
                              "', FNAME='"   + custFName +
                              "', PHONE='"   + custPhone +
                              "', COUNTRY='"  + custCountry +
                              "', ADDRESS='"  + custAddress +
                              "' WHERE CUSTID = " + custID;
          System.out.println("Update SQL statement: " + sql);
          int rc = updStmt.??
          if (rc != 0)
            ok = true;
          else
            System.out.println("In Customer.update: update failed.");
          updStmt.close();
        } // end try
        catch (SQLException exc)
        {
           System.out.println("In Customer.update, SQLException: " + exc.getMessage());
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
        try
        {
          Statement insStmt = ourDB.getConnection().createStatement();
          String    sql = "INSERT INTO "+ourDB.getLibFile()+
                          " VALUES( " + custID +
                          " , '" + custLName +
                          "', '" + custFName +
                          "', '" + custPhone +
                          "', '" + custCountry +
                          "', '" + custAddress +
                          "' )";
          System.out.println("Insert SQL statement: " + sql);
          int rc = insStmt.??
          if (rc != 0)
            ok = true;
          else
            System.out.println("In Customer.insert: insert failed.");
          insStmt.close();
        } // end try
        catch (SQLException exc)
        {
           System.out.println("In Customer.insert, SQLException: " + exc.getMessage());
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
          Statement dltStmt = ourDB.getConnection().createStatement();
          String sql = "DELETE FROM "+ourDB.getLibFile()+
                       " WHERE CUSTID = " + custID;
          System.out.println("Delete SQL statement: " + sql);
          int rc = dltStmt.??
          if (rc != 0)
            ok = true;
          else
            System.out.println("In Customer.delete: delete failed.");
          dltStmt.close();
        } // end try
        catch (SQLException exc)
        {
           System.out.println("In Customer.delete, SQLException: " + exc.getMessage());
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