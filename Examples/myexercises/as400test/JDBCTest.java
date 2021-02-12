// JDBC Test


package as400test;
import com.ibm.as400.access.*;

import java.io.IOException;

public class JDBCTest {
  public static void main(String []args) {
    AS400 as = new AS400();
    try {
      as.connectService(AS400.COMMAND);
    }catch(AS400SecurityException e){
      e.printStackTrace();
    }
    catch(IOException e){
      e.printStackTrace();
    }
  }
}