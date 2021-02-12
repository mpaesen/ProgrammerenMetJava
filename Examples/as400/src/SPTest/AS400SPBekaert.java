package SPTest;

import java.sql.*;

class AS400SPBekaert
{
	Connection con = null;
	long c = 0;

	AS400SPBekaert(final String[] args)
	{
		try
		{
			Class.forName("com.ibm.as400.access.AS400JDBCDriver");
		}
		catch (final ClassNotFoundException e)
		{
			System.out.println("JDBC Driver not found: " + e);
			System.exit(0);
		}

		try
		{
			con = DriverManager.getConnection("jdbc:as400://192.168.10.21/ibsgpl;");
			final long timer1 = System.currentTimeMillis();
			final Statement stmt = con.createStatement();
			final CallableStatement pgm = con.prepareCall(" CALL ibsgpl.MAILSP01(?, ?, ?)");
			pgm.setString(1, args[0]);
			pgm.setString(2, args[1]);
			pgm.setString(3, args[2]);
			pgm.execute();

		}
		catch (final SQLException e)
		{
			e.printStackTrace();
			System.out.println("SQL error : " + e);
		}
	}

	public static void main(final String[] pList)
	{
		new AS400SPBekaert(pList);
		System.exit(0);
	}
}
