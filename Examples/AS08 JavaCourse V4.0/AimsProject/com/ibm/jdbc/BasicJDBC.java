package com.ibm.jdbc;

import com.ibm.as400.access.*;

import java.sql.*;

public class BasicJDBC {

	public static void main(String args[]) {
		String driver = "com.ibm.as400.access.AS400JDBCDriver";
		String url = "jdbc:as400://as400tst/as08012";
		Connection con;
		String user = "AS08012";
		String password = "AS08012DKV";
		Statement stmt;
		String projID = "OP1010";
		String sql = "select * from project where projno ='"+ projID +"'";
		ResultSet rs;
		ResultSetMetaData rsmdta;
		int cols;
		
		try {
			DriverManager.registerDriver(new AS400JDBCDriver());
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rsmdta= rs.getMetaData();
			cols = rsmdta.getColumnCount();
			
			if(rs.next()){
				for(int i=1; i<= cols; i++){
					System.out.println(rsmdta.getColumnName(i)+":\t"+rs.getString(i));
				}
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
