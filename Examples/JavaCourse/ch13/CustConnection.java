//import java.sql.*;
package ch13;
import com.ibm.as400.access.*;

/**
 * A class for maintaining a connection to the customer DB2/400 database. Usage:
 * instantiate, passing the name/tcp-address of the system to connect to, as well as the
 * library and file name of the customer db. connect(), which returns true/false if it worked.
 * Pass the userId and password, or leave null to be prompted. If false returned, call getLastSQLError()
 * getLastError(), when a call returns false, and you want the exception text to display to the users
 * getxxx(), when you need to get the system name, library name, or file name disconnect(), when closing the application
 */
public class CustConnection {
    // DDM record access Vars
    private AS400 conn;
    private String ifsFile;
    private SequentialFile seqAccess;
    private KeyedFile keyAccess;
    private AS400FileRecordDescription rd;
    // Original vars (JDBC)
    // private Connection conn;
    // private PreparedStatement returnUpdateStmt = null;
    // private PreparedStatement returnReadStmt = null;
    private String system;
    private String library;
    private String file;
    private String libfile;
    private String lastError = null;
    private String connectURL = null;
    private boolean registered = false;
    private boolean nativeDriver = false;
    private boolean connected = false;
    private boolean prepared = false;

    /**
     * Constructor. Will decide whether we are running on the AS/400 or not, and if yes will register the native
     * JDBC driver, and if not will register the AS/400 Toolbox for Java JDBC driver. This registration is done by
     * dynamically loading the appropriate class, rather than statically using the class name. This will allow the code to
     * compile locally on Windows even without access to the AS/400 native JDBC driver.
     * @param name of the system to connect to. Can be null in which case user is prompted when running on a client, and
     * "localhost" is used when running on the AS/400.
     * @param name of the library containing the Customer file
     * @param name of the Customer file
     */
    public CustConnection(String system, String library, String file) {
        this.system = system.toUpperCase();
        this.library = library.toUpperCase();
        this.file = file.toUpperCase();
        libfile = this.library + "/" + this.file;
        //DDM
        conn = new AS400(this.system);
        ifsFile = "/QSYS.LIB/" + this.library + ".LIB/" + this.file + ".FILE";
        keyAccess = new KeyedFile(conn, ifsFile);
        seqAccess = new SequentialFile(conn, ifsFile);
        registered = true;
        //DDM

        /*
        String osName = System.getProperty("os.name");
        String driverName = null;
        if (osName.equals("OS/400")) {
            driverName = "com.ibm.db2.jdbc.app.DB2Driver";
            connectURL = "jdbc:db2";
            nativeDriver = true;
        }
        else {
            driverName = "com.ibm.as400.access.AS400JDBCDriver";
            connectURL = "jdbc:as400";
        }
        try {
            // This is where we dynamically load the driver's class and
            //  create an object from that class...
            Driver driver = (Driver)(Class.forName(driverName).newInstance());
            // There is where we register the driver object from above...
            DriverManager.registerDriver(driver);
            // Now set some variables for use in the connect method
            registered = true;
            if (system != null)
                connectURL += "://" + system;
            else if (nativeDriver)
                connectURL += "://localhost";
            connectURL += ";naming=system";
            System.out.println("registered to driver: " + connectURL);
        }
        catch (Exception exc) {
            lastError = exc.getMessage();
            System.out.println("Register driver failed: " + lastError);
        }
        */
    } // end ctor

    /**
     * Connect to the system.
     * @param user Id for connection. Can be null, in which case user is prompted when running on a
     * client, and *current is used if running on the AS/400.
     * @param password for connection. Can be null, in which case user is prompted when running on a
     * client, and *current is used if running on the AS/400.
     */
    public boolean connect(String userId, String passWord) {
        if (!registered)
            return false;
        boolean ok = false;
        try {
        /*    String url = connectURL;
            if (userId != null)
                url += ";user=" + userId;
            if (passWord != null)
                url += ";password=" + passWord;
            conn = DriverManager.getConnection(url);
            ok = true;
         */

            conn.setUserId(userId.toUpperCase());
            conn.setPassword(passWord.toUpperCase());
            rd = new AS400FileRecordDescription(conn, ifsFile);
            RecordFormat formats[] = rd.retrieveRecordFormat();
            keyAccess.setRecordFormat(formats[0]);
            seqAccess.setRecordFormat(formats[0]);
            connected = true;
        }
        //       catch (SQLException exc) {
        catch (Exception exc) {
            lastError = exc.getMessage();
            //            System.out.println("Connect failed: " + lastError);
            System.out.println("Retrieve record formats failed: " + lastError);
            return ok;
        }
        //        return ok;
        try {
            keyAccess.open(AS400File.READ_WRITE, 0, AS400File.COMMIT_LOCK_LEVEL_NONE);
            seqAccess.open(AS400File.READ_ONLY, 50, AS400File.COMMIT_LOCK_LEVEL_NONE);
            ok = true;
        } catch (Exception exc) {
            lastError = exc.getMessage();
            System.out.println("Opening files failed: " + lastError);
        }
        return ok;
    } // end connect

    public String getLastError() {
        return lastError;
    }

    public String getIfsFile() {
        return ifsFile;
    }

    public KeyedFile getKeyedFile() {
        return keyAccess;
    }

    public SequentialFile getSeqFile() {
        return seqAccess;
    }

    public void setLastError(String error) {
        lastError = error;
    }

    public String getSystem() {
        return system;
    }

    public String getLibFile() {
        return libfile;
    }

    //    public Connection getConnection() {
    public AS400 getConnection() {
        return conn;
    }

    public void disConnect() {
        if (conn != null) {
            // close the database connection
            try {
                //                conn.close();
                keyAccess.close();
                seqAccess.close();
                //            } catch (SQLException ex) {
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
                //DDM
                conn.disconnectAllServices();
                conn = null;
                //DDM
            }
        }
    } // end disConnect
} // end class CustConnection