//import java.sql.*;
import com.ibm.as400.access.*;

/**
 * A class for maintaining a connection to the customer
 * DB2/400 database.
 * Usage:
 *   instantiate, passing the name/tcp-address of the
 *                system to connect to, as well as the
 *                library and file name of the customer db.
 *   connect(), which returns true/false if it worked.
 *                Pass the userId and password, or leave
 *                null to be prompted.
 *                If false returned, call getLastSQLError()
 *   getLastError(), when a call returns false, and you
 *             want the exception text to display to the users
 *   getxxx(), when you need to get the system name,
 *             library name, or file name
 *   disconnect(), when closing the application
 */
public class CustConnection
{
    private String system;
    private String library;
    private String file;
    private String libfile;
    //private Connection conn;
    private AS400  conn;
    private String ifsFile;
    private SequentialFile seqAccess;
    private KeyedFile      keyAccess;
    private AS400FileRecordDescription rd;
    //private PreparedStatement returnUpdateStmt = null;
    //private PreparedStatement returnReadStmt = null;

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
     * @param name of the library containing the Customer file
     * @param name of the Customer file
     */
    public CustConnection(String system,
                          String library, String file)
    {
        this.system = system.toUpperCase();
        this.library= library.toUpperCase();
        this.file   = file.toUpperCase();
        libfile = this.library + "/" + this.file;

        conn = new AS400(this.system);
        ifsFile = "/QSYS.LIB/" + this.library +
                  ".LIB/" + this.file + ".FILE";
        keyAccess = new KeyedFile(conn,ifsFile);
        seqAccess = new SequentialFile(conn,ifsFile);

        registered = true;
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
           conn.setUserId(userId.toUpperCase());
           conn.setPassword(passWord.toUpperCase());
           rd = new AS400FileRecordDescription(conn,ifsFile);
           RecordFormat formats[] = rd.retrieveRecordFormat();
           keyAccess.setRecordFormat(formats[0]);
           seqAccess.setRecordFormat(formats[0]);
           connected = true;
        }
        catch (Exception exc)
        {
           lastError = exc.getMessage();
           System.out.println("Retrieve record formats failed: " +
                              lastError);
           return ok;
        }
        try
        {
           keyAccess.open(AS400File.READ_WRITE, 0,
             AS400File.COMMIT_LOCK_LEVEL_NONE);
           seqAccess.open(AS400File.READ_ONLY, 0,
             AS400File.COMMIT_LOCK_LEVEL_NONE);
           ok = true;
        }
        catch (Exception exc)
        {
           lastError = exc.getMessage();
           System.out.println("Opening files failed: " +
                              lastError);
        }
        return ok;
    } // end connect

    public String getIfsFile()
    {
        return ifsFile;
    }
    public KeyedFile getKeyedFile()
    {
        return keyAccess;
    }
    public SequentialFile getSeqFile()
    {
        return seqAccess;
    }

    public String getLastError()
    {
        return lastError;
    }
    public void setLastError(String error)
    {
        lastError = error;
    }
    public String getSystem()
    {
        return system;
    }
    public String getLibFile()
    {
        return libfile;
    }
    public AS400 getConnection()
    {
        return conn;
    }

    public void disConnect()
    {
       if (conn!=null)
         {
            // close the database connection
            try
            {
              keyAccess.close();
              seqAccess.close();
            }
            catch(Exception exc) {}
            conn.disconnectAllServices();
            conn = null;
         }
    } // end disConnect

} // end class CustConnection
