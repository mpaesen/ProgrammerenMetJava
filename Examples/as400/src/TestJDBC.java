//TestJDBC

import com.ibm.as400.access.*;

import java.sql.*;

public class TestJDBC{
  public static void main(String args[]){
  	String as400 = new String("BEPROI02");
  	String library = new String("QGPL");
  	String user = "INSTJAVA";
  	String password = "INSTJAVA";
	System.out.println("Inside TestJDBC");
     try
     {
	DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());
	//AS400 as = new AS400(as400, user, password);
	//as.connectService(AS400.DATABASE);
	Connection con = DriverManager.getConnection("jdbc:as400://10.1.99.51/;naming=sql;errors=full;dateformat=iso;extended dynamic=true;package=JDBCEX;package library=QGPL");
	
	PreparedStatement pstmt =con.prepareStatement("select * from QGPL.QAFCTUTDBF");
	ResultSet rs = pstmt.executeQuery();

	//System.out.println("Part\tDescription\t\t\tQty\tDate\t\tPrice");
	System.out.println("-----------------------------------------------------------------------");
	while(rs.next())
	{  
	   System.out.println(
		rs.getString("CUSTNAME")+"\t"+rs.getBigDecimal("CUSTNUM")+"\t"+
		"\t"+rs.getString("CUSTADDR")+
			"\t"+rs.getString("CUSTCITY")+"\t"+Integer.toString(rs.getInt("CUSTZIP"))+" "+	
			"\t"+"\t"+rs.getBigDecimal("CUSTBAL")+rs.getString("STATE"));
	}
	System.out.println("-----------------------------------------------------------------------");


	}catch(SQLException e){
	e.printStackTrace();
	     e.printStackTrace();
	     System.exit(1);
      }
      
      catch(Exception e){
	     e.printStackTrace();
	     System.exit(1);
      }
     System.out.println("Class found OK!");
     System.exit(0);
  }
}

