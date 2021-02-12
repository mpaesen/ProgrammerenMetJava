package SPTest;

import java.sql.*;

class AS400SPE6
{
	Connection con = null;
	long c = 0;

	AS400SPE6()
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
			con = DriverManager.getConnection("jdbc:as400://10.251.153.69/;");
			final long timer1 = System.currentTimeMillis();
			final Statement stmt = con.createStatement();
			final CallableStatement pgm = con.prepareCall(" CALL ico600dp.E6GETBP(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pgm.setString(3, "Mathy");
			pgm.setString(4, "00000000001");
			pgm.registerOutParameter(1, java.sql.Types.DECIMAL);
			pgm.registerOutParameter(2, java.sql.Types.CHAR);

			pgm.registerOutParameter(4, java.sql.Types.CHAR);
			pgm.registerOutParameter(5, java.sql.Types.CHAR);
			pgm.registerOutParameter(6, java.sql.Types.CHAR);
			pgm.registerOutParameter(7, java.sql.Types.CHAR);
			pgm.registerOutParameter(8, java.sql.Types.DECIMAL);
			pgm.registerOutParameter(9, java.sql.Types.DECIMAL);
			pgm.registerOutParameter(10, java.sql.Types.DECIMAL);
			pgm.registerOutParameter(11, java.sql.Types.DECIMAL);

			try
			{
				pgm.execute();

				System.out.println("Procedure Executed Active:" + pgm.getString(5));
				System.out.println("\tPhone" + pgm.getString(6));
				System.out.println("\tFax" + pgm.getString(7));
				System.out.println("\tCredit Limit" + pgm.getBigDecimal(8));
				System.out.println("\tOpen Balance" + pgm.getBigDecimal(9));
				System.out.println("\tTurn Over LY" + pgm.getBigDecimal(10));
				System.out.println("\tTurn Over YTD" + pgm.getBigDecimal(11));

				System.out.println("Procedure Executed " + pgm.getString(5));

			}
			catch (final SQLException e)
			{
				e.printStackTrace();
			}

		}
		catch (final SQLException e)
		{
			System.out.println("SQL error : " + e);
			e.printStackTrace();
			return;
		}
	}

	public static void main(final String[] pList)
	{
		new AS400SPE6();
		System.exit(0);
	}
}
