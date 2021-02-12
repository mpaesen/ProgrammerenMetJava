package SPTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class AS400SPProps
{
	Connection con = null;
	long c = 0;

	AS400SPProps()
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
			//con = DriverManager.getConnection ("jdbc:as400://bei5dev;extended dynamic=true;");
			con = DatabaseManagement.getConnection();
			final long timer1 = System.currentTimeMillis();
			final Statement stmt = con.createStatement();
			final CallableStatement pgm = con.prepareCall(" CALL pama.dag(?, ?)");
			pgm.setString(1, "04-01-06");
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
		new AS400SPProps();
		System.exit(0);
	}
}
