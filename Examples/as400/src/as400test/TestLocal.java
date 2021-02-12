package as400test;

import java.sql.*;

public class TestLocal
{
	Connection conn;
	PreparedStatement pstmt;

	public static void main(final String[] args)
	{
		System.out.println("Inside TestJDBC");
		try
		{
			//DriverManager.registerDriver(new com.ibm.db2.jdbc.net.DB2Driver()); // for native DB2 jdbc driver
			//DriverManager.registerDriver(new com.ibm.db2.jcc.DB2Driver()); // for native DB2 jdbc driver
			DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver()); // Toolbox driver
		}
		catch (final SQLException exc)
		{
			System.out.println("DB2 JDBC driver not found!");
			System.exit(1);
		}
		System.out.println("Class found OK");
		final TestLocal test = new TestLocal(); // create instance of us

		/* prompt for, and read, user input from console... */

		String sysName = null;
		boolean readOK = false;
		final java.io.BufferedReader d = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		while (!readOK)
		{
			System.out.println(); // blank line
			System.out.println("Please enter your system name: ");
			try
			{
				sysName = d.readLine();
				if (sysName.length() > 0)
					readOK = true;
			}
			catch (final java.io.IOException exc)
			{
				exc.printStackTrace();
			}
		}
		if (test.testConnect(sysName))
			test.testQueryAll();
		System.exit(0);
	} // end main method

	public boolean testConnect(final String sys)
	{
		System.out.println("Connecting to system " + sys + "...");
		try
		{
			//conn = DriverManager.getConnection("jdbc:as400://" + sys);
			//conn = DriverManager.getConnection("jdbc:db2:" + sys);
			final String url = "jdbc:db2://" + sys + ":50000/LIBRARY";
			final String user = "db2admin";
			final String password = "Ann-Sophie";
			conn = DriverManager.getConnection(url, user, password);
		}
		catch (final SQLException exc)
		{
			System.out.println("connect failed with: '" + exc.getMessage() + "'");
			return false;
		}
		System.out.println("connected ok");
		return true;
	}

	public boolean testQueryAll()
	{
		System.out.println("querying all...");
		try
		{
			if (pstmt == null) // only create once
				//pstmt = conn.prepareStatement("SELECT * FROM QGPL.QAUOOPT");
				pstmt = conn.prepareStatement("SELECT * FROM library.patron");
			final ResultSet rs = pstmt.executeQuery();
			System.out.println("query results:");
			while (rs.next())
				System.out.println(rs.getString(1) + " " + rs.getString(2).trim());
			rs.close();
			pstmt.close();
		} // end try
		catch (final SQLException exc)
		{
			System.out.println("query all failed with: '" + exc.getMessage() + "'");
			return false;
		}
		System.out.println("query done");
		return true;
	} // end testQueryAll method
}