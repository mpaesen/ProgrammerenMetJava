  /*�
  
In this example, n is a numeric bitmap of selected trace options.  The list
of options that can be specified includes:

   1   = client trace
   2   = Database monitor (DBMON)
   4   = Debug joblog
   8   = Save joblog
   16 = Job Trace
   32 = Save SQL output

To enable these trace options, select the desired options, add together,
and set the server trace property to this value.

*/


  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.SQLException;
  import java.util.Properties;
  
  public class JDBCDebug{
  public static void main(String args[]){
  
  // JDBC connection using URL to set property
   try
   {
     //Register the driver
     Class.forName("com.ibm.as400.access.AS400JDBCDriver");
   }
   catch(Exception e)
   {
   }

   Connection cnAS400;
   Properties props = new Properties();
   props.setProperty("user", "BEMPN");
   props.setProperty("password", "augustus01");
   props.setProperty("server trace", "16");

   try
   {
     cnAS400 = DriverManager.getConnection("jdbc:as400://BEI5DEV", props);
   }
   catch(SQLException e)
   {
     System.out.println(e.getMessage());
   }
   }
 }