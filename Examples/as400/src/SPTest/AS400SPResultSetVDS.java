package SPTest;

import java.sql.*;

class AS400SPResultSetVDS
{
	Connection con = null;
	long c = 0;

	AS400SPResultSetVDS()
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
			con = DriverManager.getConnection("jdbc:as400://inter;extended dynamic=true;");
			final long timer1 = System.currentTimeMillis();
			final Statement stmt = con.createStatement();

			final CallableStatement pgm = con.prepareCall("call isisvds.dynamicsql('select * from asqvsalfpr.arbs')");

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
		new AS400SPResultSetVDS();
		System.exit(0);
	}
}
