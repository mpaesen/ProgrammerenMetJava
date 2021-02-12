package ch13;

import ch13.dates.DatFmt;
import ch13.dates.DateDelta;

import java.sql.*;

/** Represents a car in a car rental lot */
public class Car {
    // private instance variables...
    private RentalConnection ourDB;
    private boolean preparedOK = false;
    // Variables matching fields in database record...
    private String carPlate = null;
    private String carStatus = null;
    private String carClass = null;
    private String carMake = null;
    private String carColor = null;
    private Timestamp carRentalStart = null;
    private Timestamp carRentalEnd = null;
    // Constants
    public static final String STATUS_RENTED = "R";
    public static final String STATUS_NOTRENTED = "N";

    /** Constructor */
    public Car(RentalConnection ourDB) {
        this.ourDB = ourDB;
    } // end ctor

    public boolean preparedOK() {
        return preparedOK;
    }

    /** Initialize just the plate (key field), and read this entry from the database, populating the fields */
    public boolean read(String plate) {
        carPlate = plate;
        boolean ok = false;
        try {
            PreparedStatement readStmt = ourDB.getReturnReadStatement();
            readStmt.setString(1, carPlate);
            ResultSet rs = readStmt.executeQuery();
            if (rs.next()) {
                carClass = rs.getString(2).trim();
                carMake = rs.getString(3).trim();
                carColor = rs.getString(4).trim();
                carStatus = rs.getString(5).trim();
                carRentalStart = rs.getTimestamp(6);
                if (rs.wasNull())
                    carRentalStart = null;
                carRentalEnd = rs.getTimestamp(7);
                if (rs.wasNull())
                    carRentalEnd = null;
                ok = true;
            }
            rs.close();
        } // end try
        catch (SQLException exc) {
            System.out.println("In car.read, SQLException: " + exc.getMessage());
        }
        return ok;
    } // end of read

    /** Initialize just the classification (also needed for renting) */
    public void setCarClass(String carClass) {
        this.carClass = carClass;
    } // end of setCarClass

    public String rentIt(String classification, String color, String make) {
        carClass = classification == null ? null : padString(classification, 10);
        carMake = make == null ? null : padString(make, 10);
        carColor = color == null ? null : padString(color, 10);
        carPlate = null;
        // ok, we've been asked to rent a car matching the
        // plate, class, make and color that have been
        // specified. Do a DB query first to see if there
        // is a car for us... note that we can use a previously
        // prepared statement because we don't know until now
        // whether to search on make and/or color...
        try {
            Statement stmt = ourDB.getConnection().createStatement();
            ResultSet rs;
            String sqlstring = "SELECT * FROM " + ourDB.getLibFile() + " WHERE CLASS = '" + carClass + "'";
            if (carMake != null)
                sqlstring += " AND MAKE = '" + carMake + "'";
            if (carColor != null)
                sqlstring += " AND COLOR = '" + carColor + "'";
            sqlstring += " AND STATUS = '" + STATUS_NOTRENTED + "'";
            sqlstring += " FOR UPDATE";
            System.out.println("Inside rent; read stmt: " + sqlstring);
            rs = stmt.executeQuery(sqlstring);
            if (rs.next()) {
                carMake = rs.getString(3).trim();
                carColor = rs.getString(4).trim();
                carRentalStart = new Timestamp(System.currentTimeMillis());
                // ok, found a car. Rent it by setting status.
                // We will do a POSITIONED UPDATE since we are already at the
                // place we want to be...
                // Note, we chose to use a PreparedStatement, even though
                // we are only doing this once, so as to ensure the
                // date value is set properly in the SQL statement. Let
                // JDBC do it for us, with the setTimestamp method!
                String updSql = "UPDATE  " + ourDB.getLibFile() + " SET STATUS='R', RENTDATE=? WHERE CURRENT OF "
                    + rs.getCursorName();
                PreparedStatement updStmt = ourDB.getConnection().prepareStatement(updSql);
                updStmt.setTimestamp(1, carRentalStart);
                System.out.println("Inside rent; update stmt: " + updSql);
                updStmt.executeUpdate();
                carStatus = STATUS_RENTED;
                carPlate = rs.getString(1).trim();
                updStmt.close();
            }
            else
                System.out.println("Inside rent. No matching record.");
            rs.close();
            stmt.close();
        }
        catch (SQLException exc) {
            System.out.println("Inside rent. SQLException = " + exc.getMessage());
        }
        return carPlate;
    } // end rentIt

    public DateDelta returnIt() {
        DateDelta elapsed = null;
        Statement stmt;
        carRentalEnd = new Timestamp(System.currentTimeMillis());
        try {
            PreparedStatement returnStmt = ourDB.getReturnUpdateStatement();
            returnStmt.setTimestamp(1, carRentalEnd);
            returnStmt.setString(2, carPlate);
            returnStmt.executeUpdate();
            carStatus = STATUS_NOTRENTED;
            elapsed = new DateDelta(carRentalStart, carRentalEnd);
        }
        catch (SQLException exc) {
        }
        return elapsed;
    }

    public String getDisplayInfo(boolean displayRentedInfo) {
        String display = "Plate: " + carPlate;
        display += " class: " + carClass;
        display += " make: " + carMake;
        display += " color: " + carColor;
        if (displayRentedInfo && (carStatus.equals(STATUS_RENTED))) {
            DatFmt datfmt = new DatFmt();
            display += " Rented: " + datfmt.format(carRentalStart);
        }
        return display;
    }

    public String getPlate() {
        return carPlate;
    }

    public String getStatus() {
        return carStatus;
    }

    public String getClassification() {
        return carClass;
    }

    public String getMake() {
        return carMake;
    }

    public String getColor() {
        return carColor;
    }

    public boolean isRented() {
        return carStatus.equals(STATUS_RENTED);
    }

    public static final String padString(String padString, int finalLen) {
        StringBuffer temp = new StringBuffer(padString);
        int curLen = padString.length();
        int padAmount = finalLen - curLen;
        for (int idx = 0; idx < padAmount; idx++)
            temp.append(' ');
        return temp.toString();
    }
} // end of class CarLot
