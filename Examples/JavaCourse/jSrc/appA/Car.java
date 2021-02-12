package jSrc.appA;

import jSrc.appA.dates.DatFmt;
import jSrc.appA.dates.DateDelta;

import java.sql.*;
/**
 *  Represents a car in a car rental lot
 */
public class Car
{
    // private instance variables...
    private RentalConnection ourDB;
    private boolean preparedOK = false;
    // Variables matching fields in database record...
    private String carPlate=null;
    private String carStatus=null;
    private String carClass=null;
    private String carMake=null;
    private String carColor=null;
    private Timestamp carRentalStart=null;
    private Timestamp carRentalEnd=null;
    // Constants
    public  static final String STATUS_RENTED   = "R";
    public  static final String STATUS_NOTRENTED= "N";

    /**
     * Constructor
     */
    public Car(RentalConnection ourDB)
    {
        this.ourDB = ourDB;
    } // end ctor

    public boolean preparedOK()
    {
        return preparedOK;
    }

    public DateDelta returnIt()
    {
        DateDelta elapsed = null;
        Statement stmt;
        carRentalEnd = new Timestamp(System.currentTimeMillis());
        try
        {
          PreparedStatement returnStmt = ourDB.getReturnUpdateStatement();
          returnStmt.setTimestamp(1, carRentalEnd);
          returnStmt.setString(2, carPlate);
          returnStmt.executeUpdate();
          carStatus = STATUS_NOTRENTED;
          elapsed = new DateDelta(carRentalStart, carRentalEnd);
        }
        catch (SQLException exc)
        {
        }
        return elapsed;
    }

    /**
     * Initialize just the classification (also needed for renting)
     */
    public void setCarClass(String carClass)
    {
        this.carClass = carClass;
    } // end of setCarClass

    public String getDisplayInfo(boolean displayRentedInfo)
    {
        String display = "PLATE: " + carPlate;
        display += ", CLASS: " + carClass;
        display += ", MAKE: " + carMake;
        display += ", COLOR: " + carColor;
        if (displayRentedInfo && (carStatus.equals(STATUS_RENTED)))
          {
            DatFmt datfmt = new DatFmt();
            display += ", Rented: " + datfmt.format(carRentalStart);
          }
        return display;
    }

    public String getPlate()
    {
        return carPlate;
    }
    public void setPlate(String newPlate)
    {
        carPlate = newPlate;
    }

    public String getStatus()
    {
        return carStatus;
    }
    public void setStatus(String newStatus)
    {
        carStatus = newStatus;
    }

    public String getClassification()
    {
        return carClass;
    }
    public void setClassification(String newClass)
    {
        carClass = newClass;
    }

    public String getMake()
    {
        return carMake;
    }
    public void setMake(String newMake)
    {
        carMake = newMake;
    }

    public String getColor()
    {
        return carColor;
    }
    public void setColor(String newColor)
    {
        carColor = newColor;
    }

    public boolean isRented()
    {
        return carStatus.equals(STATUS_RENTED);
    }
    public void setRented(boolean rented)
    {
        carStatus = rented ? STATUS_RENTED : STATUS_NOTRENTED;
    }
    public Timestamp getRentalStart()
    {
        return carRentalStart;
    }
    public void setRentalStart(Timestamp newRentalStart)
    {
        carRentalStart = newRentalStart;
    }
    public void setRentalEnd(Timestamp newRentalEnd)
    {
        carRentalEnd = newRentalEnd;
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

    /**
     * Object factory method to create a car object and populate it with
     * information from the database for given car plate key value.
     * @param RentalConnection object
     * @param Plate of car record to read from database
     * @return Car object if car of given plate found, null otherwise
     */
    public static Car createCar(RentalConnection ourDB, String plate)
    {
        Car currCar = null;
        boolean ok = false;
        try
        {
          PreparedStatement readStmt = ourDB.getReturnReadStatement();
          readStmt.setString(1,plate);
          ResultSet rs = readStmt.executeQuery();
          if (rs.next())
            {
               currCar = new Car(ourDB);
               currCar.setClassification(rs.getString(2).trim());
               currCar.setMake(rs.getString(3).trim());
               currCar.setColor(rs.getString(4).trim());
               currCar.setStatus(rs.getString(5).trim());
               Timestamp carRentalStart = rs.getTimestamp(6);
               currCar.setRentalStart(rs.wasNull() ? null : carRentalStart);
               Timestamp carRentalEnd = rs.getTimestamp(7);
               currCar.setRentalEnd(rs.wasNull() ? null : carRentalEnd);
               ok = true;
            }
          rs.close();
        } // end try
        catch (SQLException exc)
        {
           System.out.println("In car.read, SQLException: " + exc.getMessage());
        }
        return currCar;
    } // end of createCar

    /**
     * Object factory method to rent a car and retun the Car object for that rented car
     * or null if no car with given criteria is available
     * @param RentalConnection object
     * @param Preferred classification or *ANY or null if no preferenceu
     * @param Preferred color or *ANY or null if no preference
     * @param Preferred make or *ANY or null if no preference
     * @return Car object if match of given criteria found, null otherwise
     */
    public static Car rentACar(RentalConnection ourDB, String classification, String color, String make)
    {
        String carClass = classification==null?null:padString(classification,10);
        String carMake  = make==null?null:padString(make,10);
        String carColor = color==null?null:padString(color,10);
        String carPlate = null;
        Car newCar = null;
        // ok, we've been asked to rent a car matching the
        // plate, class, make and color that have been
        // specified. Do a DB query first to see if there
        // is a car for us... note that we can use a previously
        // prepared statement because we don't know until now
        // whether to search on make and/or color...
        try
        {
           Statement stmt = ourDB.getConnection().createStatement();
           ResultSet rs;
           String sqlstring = "SELECT * FROM " + ourDB.getLibFile() + " WHERE CLASS = '"+carClass+"'";
           if (carMake != null)
             sqlstring += " AND MAKE = '" + carMake + "'";
           if (carColor != null)
             sqlstring += " AND COLOR = '" + carColor + "'";
           sqlstring += " AND STATUS = '"+STATUS_NOTRENTED+"'";
           sqlstring += " FOR UPDATE";
           System.out.println("Inside rent; read stmt: " + sqlstring);

           rs = stmt.executeQuery(sqlstring);
           if (rs.next())
             {
              newCar = new Car(ourDB);
              newCar.setClassification(rs.getString(2).trim());
              newCar.setMake(rs.getString(3).trim());
              newCar.setColor(rs.getString(4).trim());
              newCar.setRentalStart(new Timestamp(System.currentTimeMillis()));
              newCar.setRentalEnd(null);
              // ok, found a car. Rent it by setting status.
              // We will do a POSITIONED UPDATE since we are already at the
              // place we want to be...
              // Note, we chose to use a PreparedStatement, even though
              // we are only doing this once, so as to ensure the
              // date value is set properly in the SQL statement. Let
              // JDBC do it for us, with the setTimestamp method!
              String updSql = "UPDATE  " + ourDB.getLibFile() + " SET STATUS='R', RENTDATE=? WHERE CURRENT OF " + rs.getCursorName();
              PreparedStatement updStmt = ourDB.getConnection().prepareStatement(updSql);
              updStmt.setTimestamp(1,newCar.getRentalStart());
              updStmt.executeUpdate();
              newCar.setStatus(STATUS_RENTED);
              newCar.setPlate(rs.getString(1).trim());
              updStmt.close();
             }
           else
             System.out.println("Inside rent. No matching record.");
           rs.close();
           stmt.close();
        }
        catch (SQLException exc)
        {
           System.out.println("Inside rent. SQLException = " + exc.getMessage());
           newCar = null;
        }
        return newCar;
    } // end rentIt

    public static void displayRentedCars(RentalConnection ourDB)
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

       String sqlQuery = "SELECT * FROM " + ourDB.getLibFile();
       try
       {
          System.out.println();
          System.out.println("Performing execute query...");
          Statement stmt = ourDB.getConnection().createStatement();
          sqlQuery += " WHERE STATUS = 'R'";
          //  sqlQuery += " WHERE STATUS = 'N'";
          rs = stmt.executeQuery(sqlQuery);
          System.out.println("Querying result set...");
          while ( rs.next() )
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
             System.out.println("  " + carPlate + " " + carClass + " " + carMake + " " +
                                  carColor + carStatusString+
                                  carRentDateString + carReturnDateString);
             count++;
          }
          rs.close();
          stmt.close();
          stmt = null;
          System.out.println("Database query done. Total rows: " + count);
       }
       catch (SQLException exc)
       {
          System.out.println("Unexpected Error: "+exc.getMessage());
       }
       System.out.println();
    } // end displayRentedCars

} // end of class Car