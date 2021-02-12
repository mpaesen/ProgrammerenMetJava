
	/**
	 * DerbyIdentityColumn.java
	 * Copyright (c) 2007 by Dr. Herong Yang. All rights reserved.
	 */

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
	public class Test {
	  public static void main(String [] args) {
	    Connection con = null;
	    try {
	    	try{
	    	Class.forName("org.apache.derby.jdbc.ClientDriver");
	    	}
	    	catch (Exception e) {
				e.printStackTrace();
			}
	      con = DriverManager.getConnection(
	        "jdbc:derby://localhost/mensen; create=true;");

	      PreparedStatement query=con.prepareStatement("select * from adres");
	      ResultSet resutls= query.executeQuery();
	      while (resutls.next()){
	    	  System.out.print(resutls.getInt("ID"));
	      }
	      query.close();
//
	      con.close();        
	    } catch (Exception e) {
	      System.err.println("Exception: "+e.getMessage());
	    }
  }
}


