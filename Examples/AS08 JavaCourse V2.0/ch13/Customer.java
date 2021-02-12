
package ch13;

import com.ibm.as400.access.*;

//import java.sql.*;

/** Represents a car in a car rental lot */
public class Customer {
    // private instance variables...
    //DDM
    private Record currRecord = null;
    //DDM
    private CustConnection ourDB;
    // Variables matching fields in database record...
    private int custID = -1;
    private String custLName = null;
    private String custFName = null;
    private String custPhone = null;
    private String custCountry = null;
    private String custAddress = null;

    /** Constructor */
    public Customer(CustConnection ourDB) {
        this.ourDB = ourDB;
    } // end ctor

    /** Initialize just the ID (key field), and read this entry from the database, populating the fields */
    public boolean read(int id) {
        custID = id;
        boolean ok = false;
        //DDM
        Object[] keyField = new Object[1];
        keyField[0] = new Integer(id);
        //DDM
        try {
            currRecord = ourDB.getKeyedFile().read(keyField);
            if (currRecord != null) {
                custLName = (String)currRecord.getField(1);
                custFName = (String)currRecord.getField(2);
                custPhone = (String)currRecord.getField(3);
                custCountry = (String)currRecord.getField(4);
                custAddress = (String)currRecord.getField(5);
                ok = true;
            }
            //DDM

            /*
            Statement readStmt = ourDB.getConnection().createStatement();
            String sql = "Select * from " + ourDB.getLibFile() + " where CUSTID = " + custID;
            System.out.println("Read SQL statement: " + sql);
            ResultSet rs = readStmt.executeQuery(sql);
            if (rs.next()) {
                custLName = rs.getString("LNAME").trim();
                custFName = rs.getString("FNAME").trim();
                custPhone = rs.getString("PHONE").trim();
                custCountry = rs.getString("COUNTRY").trim();
                custAddress = rs.getString("ADDRESS").trim();
                ok = true;
            }
            rs.close();
            readStmt.close();
            */
        } // end try
        //        catch (SQLException exc) {
        catch (Exception exc) {
            System.out.println("In Customer.read, Exception: " + exc.getMessage());
            ourDB.setLastError(exc.getMessage());
        }
        return ok;
    } // end of read

    /** Assuming all fields are initialized, this method updates this entry in the database */
    public boolean update() {
        boolean ok = false;
        try {
            //DDM
            currRecord.setField(0, new Integer(custID));
            currRecord.setField(1, custLName);
            currRecord.setField(2, custFName);
            currRecord.setField(3, custPhone);
            currRecord.setField(4, custCountry);
            currRecord.setField(5, custAddress);
            ourDB.getKeyedFile().update(currRecord);
            ok = true;
            //DDM

            /*
            Statement updStmt = ourDB.getConnection().createStatement();
            String sql = "UPDATE " + ourDB.getLibFile() + " SET LNAME='" + custLName + "', FNAME='" + custFName +
                "', PHONE='" + custPhone + "', COUNTRY='" + custCountry + "', ADDRESS='" + custAddress +
                "' WHERE CUSTID = " + custID;
            System.out.println("Update SQL statement: " + sql);
            int rc = updStmt.executeUpdate(sql);
            if (rc != 0)
                ok = true;
            else
                System.out.println("In Customer.update: update failed.");
            updStmt.close();
            */
        } // end try
        //        catch (SQLException exc) {
        catch (Exception exc) {
            System.out.println("In Customer.update, Exception: " + exc.getMessage());
            ourDB.setLastError(exc.getMessage());
        }
        return ok;
    } // end of update

    /** Assuming all fields are initialized, this method inserts this entry in the database */
    public boolean insert() {
        boolean ok = false;
        //DDM
        RecordFormat rf = ourDB.getKeyedFile().getRecordFormat();
        currRecord = rf.getNewRecord();
        //DDM
        try {
            //DDM
            currRecord.setField(0, new Integer(custID));
            currRecord.setField(1, custLName);
            currRecord.setField(2, custFName);
            currRecord.setField(3, custPhone);
            currRecord.setField(4, custCountry);
            currRecord.setField(5, custAddress);
            ourDB.getKeyedFile().write(currRecord);
            ok = true;
            //DDM

            /*
            Statement insStmt = ourDB.getConnection().createStatement();
            String sql = "INSERT INTO " + ourDB.getLibFile() + " VALUES( " + custID + " , '" + custLName + "', '" + custFName +
                "', '" + custPhone + "', '" + custCountry + "', '" + custAddress + "' )";
            System.out.println("Insert SQL statement: " + sql);
            int rc = insStmt.executeUpdate(sql);
            if (rc != 0)
                ok = true;
            else
                System.out.println("In Customer.insert: insert failed.");
            insStmt.close();
            */
        } // end try
        //        catch (SQLException exc) {
        catch (Exception exc) {
            System.out.println("In Customer.insert, Exception: " + exc.getMessage());
            ourDB.setLastError(exc.getMessage());
        }
        return ok;
    } // end of insert

    /** Given the customer ID, deletes this entry from the database */
    public boolean delete(int id) {
        custID = id;
        boolean ok = false;
        try {
            //DDM
            Object[] keyField = new Object[1];
            keyField[0] = new Integer(id);
            ourDB.getKeyedFile().deleteRecord(keyField);
            ok = true;
            //DDM

            /*
            Statement dltStmt = ourDB.getConnection().createStatement();
            String sql = "DELETE FROM " + ourDB.getLibFile() + " WHERE CUSTID = " + custID;
            System.out.println("Delete SQL statement: " + sql);
            int rc = dltStmt.executeUpdate(sql);
            if (rc != 0)
                ok = true;
            else
                System.out.println("In Customer.delete: delete failed.");
            dltStmt.close();
            */
        } // end try
        //        catch (SQLException exc) {
        catch (Exception exc) {
            System.out.println("In Customer.delete, Exception: " + exc.getMessage());
            ourDB.setLastError(exc.getMessage());
        }
        return ok;
    } // end of delete

    public String getDisplayInfo() {
        String display = "Customer ID: " + custID;
        display += " lname: " + custLName;
        display += " fname: " + custFName;
        display += " phone: " + custPhone;
        display += " country:" + custCountry;
        display += " address:" + custAddress;
        return display;
    }

    public int getID() {
        return custID;
    }

    public String getLName() {
        return custLName;
    }

    public String getFName() {
        return custFName;
    }

    public String getPhone() {
        return custPhone;
    }

    public String getCountry() {
        return custCountry;
    }

    public String getAddress() {
        return custAddress;
    }

    public void setID(int id) {
        custID = id;
    }

    public void setLName(String lname) {
        custLName = lname;
    }

    public void setFName(String fname) {
        custFName = fname;
    }

    public void setPhone(String phone) {
        custPhone = phone;
    }

    public void setCountry(String country) {
        custCountry = country;
    }

    public void setAddress(String address) {
        custAddress = address;
    }

    public static final String padString(String padString, int finalLen) {
        StringBuffer temp = new StringBuffer(padString);
        int curLen = padString.length();
        int padAmount = finalLen - curLen;
        for (int idx = 0; idx < padAmount; idx++)
            temp.append(' ');
        return temp.toString();
    }
} // end of class Customer
