// JDBC Test


package as400test;

import com.ibm.as400.access.*;

public class JDBCTest {
  public static void main(String []args)throws Exception{
    AS400 as = new AS400();
    as.connectService(AS400.COMMAND);
  }
}