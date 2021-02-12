package ch13;

import java.sql.*;

public class TestJDBC {
	Connection conn;
	PreparedStatement pstmt;

	public static void main(String args[]) {
		System.out.println("Inside TestJDBC");
		try {
			DriverManager.registerDriver(
				new com.ibm.as400.access.AS400JDBCDriver());
			//com.ibm.db2.jdbc.app.DB2Driver());  // for native os/400 jdbc driver
		} catch (SQLException exc) {
			System.out.println("DB2/400 JDBC driver not found!");
			System.exit(1);
		}
		System.out.println("Class found OK");
		TestJDBC test = new TestJDBC(); // create instance of us

		/* prompt for, and read, user input from console... */

		String sysName = null;
		boolean readOK = false;
		java.io.BufferedReader d =
			new java.io.BufferedReader(
				new java.io.InputStreamReader(System.in));
		while (!readOK) {
			System.out.println(); // blank line
			System.out.println("Please enter your system name: ");
			try {
				sysName = d.readLine();
				if (sysName.length() > 0)
					readOK = true;
			} catch (java.io.IOException exc) {
				exc.printStackTrace();
			}
		}
		if (test.testConnect(sysName))
			test.testQueryAll();
		System.exit(0);
	} // end main method

	public boolean testConnect(String sys) {
		System.out.println("Connecting to system " + sys + "...");
		try {
			conn = DriverManager.getConnection("jdbc:as400://" + sys);
		} catch (SQLException exc) {
			System.out.println(
				"connect failed with: '" + exc.getMessage() + "'");
			return false;
		}
		System.out.println("connected ok");
		return true;
	}

	public String getTypeToString(ResultSet rs, int idx) {
		int type = 1111;
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			type = rsmd.getColumnType(idx);	
			switch (type) {
				case Types.CHAR :
					return rs.getString(idx).trim();
				case Types.TIMESTAMP :
					return rs.getTimestamp(idx).toString();					
				default :
					return "NOT FOUND";
			}
		} catch (SQLException exc) {
			System.out.println(
				"query all failed with: '" + exc.getMessage() + "'");
			return "SQL ERROR IN RESULTSET";
		}catch(NullPointerException exc){
				return "NULL";
		}
	}
//beproi05beproi0be
	public boolean testQueryAll() {
		System.out.println("querying all...");
		try {
			if (pstmt == null) // only create once
				pstmt = conn.prepareStatement("SELECT * FROM QGPL.QAUOOPT");
				//pstmt = conn.prepareStatement("SELECT * FROM PAMA.CARDB");
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++)
				System.out.print("\t" + rsmd.getColumnName(i));
			System.out.println("\nquery results:");
			while (rs.next()) {
				for (int i = 1; i <= rsmd.getColumnCount(); i++)
					System.out.print("\t" + getTypeToString(rs, i));
				System.out.println();
			}
			rs.close();
			pstmt.close();
		} // end try
		catch (SQLException exc) {
			System.out.println(
				"query all failed with: '" + exc.getMessage() + "'");
			return false;
		}
		System.out.println("query done");
		return true;
	}
}