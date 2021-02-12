package SPTest;

import java.sql.*;

class AS400SP
{
	Connection con = null;
	long c = 0;

	AS400SP()
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
			con = DriverManager.getConnection("jdbc:as400://bei5dev;extended dynamic=true;");
			final long timer1 = System.currentTimeMillis();
			final Statement stmt = con.createStatement();
			final CallableStatement pgm = con.prepareCall(" CALL pama.dag(?, ?)");
			pgm.setString(1, "02-09-05");
			pgm.registerOutParameter(2, java.sql.Types.CHAR);

			try
			{
				pgm.execute();

				System.out.println("Procedure Executed " + pgm.getString(2));
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
		new AS400SP();
		System.exit(0);
	}
}
