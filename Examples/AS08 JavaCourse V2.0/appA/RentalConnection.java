package appA;


import java.sql.*;

/**
 * A class for maintaining a connection to the car
 * rental database. Also includes prepared statements
 * needed by the rent and return actions, for better
 * performance.
 * Usage:
 *   instantiate, passing the name/tcp-address of the
 *                system to connect to, as well as the
 *                library and file name of the car db.
 *   connect(), which returns true/false if it worked.
 *                Pass the userId and password, or leave
 *                null to be prompted.
 *                If false returned, call getLastSQLError()
 *   prepare(), to prepare often needed statements. If
 *                false returned, call getLastError()
 *   getxxx(), when you need to get the system name,
 *             library name, file name, or prepared
 *             statement objects
 *   disconnect(), when closing the application
 */
public class RentalConnection
{
    private String system;
    private String library;
    private String file;
    private String libfile;
    private Connection conn;
    private PreparedStatement returnUpdateStmt = null;
    private PreparedStatement returnReadStmt = null;

    private String  lastError =null;
    private String  connectURL=null;
    private boolean registered=false;
    private boolean nativeDriver = false;
    private boolean connected =false;
    private boolean prepared  =false;

    /**
     * Constructor. Will decide whether we are running on
     *  the AS/400 or not, and if yes will register the native
     *  JDBC driver, and if not will register the AS/400 Toolbox
     *  for Java JDBC driver. This registration is done by
     *  dynamically loading the appropriate class, rather than
     *  statically using the class name. This will allow the code to
     *  compile locally on Windows even without access to the AS/400
     *  native JDBC driver.
     * @param name of the system to connect to. Can be null in
     *  which case user is prompted when running on a client, and
     *  "localhost" is used when running on the AS/400.
     * @param name of the library containing the Rental file
     * @param name of the Rental car file
     */
    public RentalConnection(String system,
                            String library, String file)
    {
        this.system = system == null ? null : system.toUpperCase();
        this.library= library == null ? null : library.toUpperCase();
        this.file   = file == null ? null : file.toUpperCase();
        libfile = this.library + "/" + this.file;
        String osName = System.getProperty("os.name");
        String driverName = null;
        if (osName.equals("OS/400"))
          {
            driverName = "com.ibm.db2.jdbc.app.DB2Driver";
            connectURL = "jdbc:db2";
            nativeDriver = true;
          }
        else
          {
            driverName = "com.ibm.as400.access.AS400JDBCDriver";
            connectURL = "jdbc:as400";
          }
        try
        {
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
        catch (Exception exc)
        {
           lastError = exc.getMessage();
           System.out.println("Register driver failed: " + lastError);
        }

    } // end ctor

    /**
     * Connect to the system.
     * @param user Id for connection.
     *   Can be null, in which case user is prompted when running on a
     *    client, and *current is used if running on the AS/400.
     * @param password for connection.
     *   Can be null, in which case user is prompted when running on a
     *    client, and *current is used if running on the AS/400.
     */
    public boolean connect(String userId, String passWord)
    {
        if (!registered)
          return false;
        boolean ok = false;
        try
        {
           String url = connectURL;
           if (userId != null)
             url += ";user=" + userId;
           if (passWord != null)
             url += ";password=" + passWord;
           System.out.println("connecting to '" + connectURL + "'...");
           conn = DriverManager.getConnection(url);
           ok = true;
           connected = true;
        }
        catch (SQLException exc)
        {
           lastError = exc.getMessage();
           System.out.println("Connect failed: " + lastError);
        }
        return ok;
    } // end connect

    public boolean prepare()
    {
        if (!registered || !connected)
          return false;
        boolean ok = false;
        try
        {
          String sql = "UPDATE " + libfile + " SET STATUS = 'N'" +
                       ", RETDATE = ? WHERE PLATE = ?";
          //System.out.println("SQL Update for Return stmt: "+sql);
          returnUpdateStmt = conn.prepareStatement(sql);

          sql = "SELECT * FROM " + libfile + " WHERE PLATE = ?";
          //System.out.println("SQL Read for Return stmt: "+sql);
          returnReadStmt = conn.prepareStatement(sql);

          prepared = ok = true;
          //System.out.println("Prepared ok.");
        }
        catch (SQLException exc)
        {
          lastError = exc.getMessage();
          System.out.println("Prepare failed: "+lastError);
        }
        return ok;
    } // end prepare

    public String getLastError()
    {
        return lastError;
    }
    public String getSystem()
    {
        return system;
    }
    public String getLibFile()
    {
        return libfile;
    }
    public Connection getConnection()
    {
        return conn;
    }
    public PreparedStatement getReturnReadStatement()
    {
        return returnReadStmt;
    }
    public PreparedStatement getReturnUpdateStatement()
    {
        return returnUpdateStmt;
    }

    public void disConnect()
    {
       if (conn!=null)
         {
            try
            {
              conn.close();
            }
            catch(SQLException exc) {}
         }
    } // end disConnect

} // end class RentalConnection
