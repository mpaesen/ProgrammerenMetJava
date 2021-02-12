package ch13;

import java.sql.*;

public class TestLocal {
	Connection conn;
	PreparedStatement pstmt;

	public static void main(String[] args) {
		System.out.println("Inside TestJDBC");
		try {
			DriverManager.registerDriver(new COM.ibm.db2.jdbc.app.DB2Driver()); // for native DB2 jdbc driver
			//com.ibm.as400.access.AS400JDBCDriver();	// Toolbox driver
		} catch (SQLException exc) {
			System.out.println("DB2 JDBC driver not found!");
			System.exit(1);
		}
		System.out.println("Class found OK");
		TestLocal test = new TestLocal(); // create instance of us

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
			}
		}
		if (test.testConnect(sysName))
			test.testQueryAll();
		System.exit(0);
	} // end main method

	public boolean testConnect(String sys) {
		System.out.println("Connecting to system " + sys + "...");
		try {
			//conn = DriverManager.getConnection("jdbc:as400://" + sys);
			conn = DriverManager.getConnection("jdbc:db2:" + sys);
		} catch (SQLException exc) {
			System.out.println(
				"connect failed with: '" + exc.getMessage() + "'");
			return false;
		}
		System.out.println("connected ok");
		return true;
	}

	public boolean testQueryAll() {
		System.out.println("querying all...");
		try {
			if (pstmt == null) // only create once
				//pstmt = conn.prepareStatement("SELECT * FROM QGPL.QAUOOPT");
				pstmt = conn.prepareStatement("SELECT * FROM CUSTMAST");
			ResultSet rs = pstmt.executeQuery();
			System.out.println("query results:");
			while (rs.next())
				System.out.println(
					rs.getString(1) + " " + rs.getString(2).trim());
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
	} // end testQueryAll method
}