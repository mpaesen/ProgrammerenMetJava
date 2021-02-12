package SPTest;

import java.sql.*;

class AS400SPAFS
{
	Connection con = null;
	long c = 0;

	AS400SPAFS()
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
			con = DriverManager.getConnection("jdbc:as400://bei5dev/aafsds01;extended dynamic=true;");
			final long timer1 = System.currentTimeMillis();
			final Statement stmt = con.createStatement();
			final CallableStatement pgm = con.prepareCall(" CALL facvbop.isisacct(?, ?, ?)");
			pgm.setString(1, "G");
			pgm.setString(2, "100000000");
			pgm.registerOutParameter(3, java.sql.Types.CHAR);

			try
			{
				pgm.execute();

				System.out.println("Procedure Executed " + pgm.getString(3));
			}
			catch (final SQLException e)
			{
				e.printStackTrace();
			}

		}
		catch (final SQLException e)
		{
			System.out.println("SQL error : " + e);
			return;
		}
	}

	public static void main(final String[] pList)
	{
		new AS400SPAFS();
		System.exit(0);
	}
}
