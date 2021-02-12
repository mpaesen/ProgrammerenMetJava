//TestJDBC

import com.ibm.as400.access.*;

import java.sql.*;

public class TestJDBCNovanatie{
  public static void main(String args[]){

	System.out.println("Inside TestJDBC");
     try
     {
	DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());
	//AS400 as = new AS400(as400, user, password);
	//as.connectService(AS400.DATABASE);
	Connection con = DriverManager.getConnection("jdbc:as400://105.0.0.10;naming=sql;errors=full;dateformat=iso;extended dynamic=true;package=JDBCEX;package library=QGPL,INSTJAVA,INSTJAVA");
	PreparedStatement pstmt =con.prepareStatement("select * from QGPL.QAUOOPT");
	ResultSet rs = pstmt.executeQuery();

	//System.out.println("Part\tDescription\t\t\tQty\tDate\t\tPrice");
	System.out.println("-----------------------------------------------------------------------");
	while(rs.next())
	{  
	   System.out.println(
		rs.getString(1)+"\t"+rs.getString(2));
	}
	System.out.println("-----------------------------------------------------------------------");

     }catch(SQLException e){
     	e.printStackTrace();
	     //System.out.println("DB2/400 driver not found!");
	     System.exit(1);
      }
     /* catch(AS400SecurityException e){
	     e.printStackTrace();
	     System.exit(1);
      }*/
      catch(Exception e){
	     e.printStackTrace();
	     System.exit(1);
      }
     System.out.println("Class found OK!");
     System.exit(0);
  }
}

