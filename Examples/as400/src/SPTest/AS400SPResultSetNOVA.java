package SPTest;

import java.sql.*;

class AS400SPResultSetNOVA
{
	Connection con = null;
	long c = 0;

	AS400SPResultSetNOVA()
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
			con = DriverManager.getConnection("jdbc:as400://105.0.0.10;extended dynamic=true;");
			final long timer1 = System.currentTimeMillis();
			final Statement stmt = con.createStatement();

			final CallableStatement pgm = con.prepareCall("call qgpl.getproduct('5861361', 'AL 110')");

			final ResultSet rs = pgm.executeQuery();
			while (rs.next())
			{
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

		}
		catch (final SQLException e)
		{
			e.printStackTrace();
		}

	}

	public static void main(final String[] pList)
	{
		new AS400SPResultSetNOVA();
		System.exit(0);
	}
}
