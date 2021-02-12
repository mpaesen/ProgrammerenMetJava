package as400test;

//TestJDBC

//package as400test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TableMetaDataPropsSQL
{
	private static final String USERID = "userid";
	private static final String PASSWORD = "password";
	private static final String DRIVER = "driver";
	private static final String URL = "url";
	private static final String DATABASE = "database";
	private final String columns[];
	private final String columnTypes[];
	private final Connection con;

	private final PreparedStatement pstmt;
	private final ResultSetMetaData rmd;
	private final ResultSet rs;
	private static String userid = "USERID";
	private static String password = "PASSWORD";
	private static String driver = null;

	private static String url = null;
	private static String database = null;
	private int size;

	private static final String file = "connection.properties";

	private static Connection connection;
	private static DatabaseMetaData dbmd;

	public TableMetaDataPropsSQL(final String sql) throws SQLException
	{

		con = getConnection();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		rmd = rs.getMetaData();
		columns = new String[rmd.getColumnCount()];
		columnTypes = new String[rmd.getColumnCount()];

	}

	public String column(final int i) throws SQLException
	{
		String col = "";
		if (columnTypes[i - 1].equals("CHAR"))
			col = rs.getString(i);
		if (columnTypes[i - 1].equals("DECIMAL"))
			col = rs.getBigDecimal(i).toString();
		if (columnTypes[i - 1].equals("INTEGER"))
			col = Integer.toString(rs.getInt(i));
		if (columnTypes[i - 1].equals("NUMERIC"))
			col = rs.getString(i);
		if (columnTypes[i - 1].equals("TIMESTAMP"))
			col = rs.getString(i);
		if (col == null)
			col = " ";
		return col;
	}

	private String columnHeaders() throws SQLException
	{
		final StringBuffer kolommen = new StringBuffer();
		for (int i = 0; i < rmd.getColumnCount(); i++)
		{
			kolommen.append(rmd.getColumnName(i + 1));

			getSize(i);
			for (int j = 0; j < size - rmd.getColumnName(i + 1).trim().length(); j++)
			{
				kolommen.append(" ");
			}
			columns[i] = rmd.getColumnName(i + 1);
			columnTypes[i] = rmd.getColumnTypeName(i + 1);
		}

		return kolommen.toString();

	}

	private String columnTypes() throws SQLException
	{
		final StringBuffer myTypes = new StringBuffer();
		for (int i = 0; i < rmd.getColumnCount(); i++)
		{
			myTypes.append(columnTypes[i]);

			getSize(i);
			for (int j = 0; j < size - rmd.getColumnTypeName(i + 1).trim().length(); j++)
			{
				myTypes.append(" ");
			}
		}
		return myTypes.toString();
	}

	private void getSize(final int i) throws SQLException
	{
		size = Math.max(rmd.getColumnDisplaySize(i + 1), rmd.getColumnName(i + 1).length()) + 1;
	}

	private void printRecordDetails() throws SQLException
	{

		while (rs.next())
		{
			System.out.print(recordDetails());
		}

	}

	private String recordDetails() throws SQLException
	{
		final StringBuffer output = new StringBuffer();
		for (int i = 0; i < rmd.getColumnCount(); i++)
		{
			output.append(column(i + 1).trim());
			getSize(i);
			for (int j = 0; j < size - column(i + 1).trim().length(); j++)
			{
				output.append(" ");
			}
		}
		output.append("\n");
		return output.toString();
	}

	private void close()
	{
		try
		{
			rs.close();
			pstmt.close();
			con.close();
		}
		catch (final SQLException e1)
		{
			e1.printStackTrace();
		}
	}

	public static void main(final String args[])
	{
		System.out.println("Inside TestJDBC");
		TableMetaDataPropsSQL file = null;
		try
		{
			String sql = null;
			if (args.length == 0)
			{
				sql = "select * from QGPL.QAUOOPT";
			}
			else
			{
				sql = args[0];
			}
			file = new TableMetaDataPropsSQL(sql);

			System.out.println("-----------------------------------------------------------------------");
			System.out.println(file.columnHeaders());
			file.printRecordDetails();
			System.out.println("-----------------------------------------------------------------------");
			System.out.println(file.columnTypes());

		}
		catch (final SQLException e)
		{
			e.printStackTrace();
			System.out.println("An SQL Exception occurred");
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (file != null)
				file.close();
		}
		System.exit(0);
	}

	public static Connection getConnection() throws SQLException
	{
		if (connection == null)
		{
			getDBProperties();
			try
			{
				Class.forName(driver);
				connection = DriverManager.getConnection(url + database, userid, password);
				connection.setAutoCommit(false);
				dbmd = connection.getMetaData();
			}
			catch (final ClassNotFoundException nf)
			{
				throw new SQLException(driver);
			}
		}
		return connection;
	}

	public static void getDBProperties()
	{
		String fileName = file;
		try
		{
			InputStream inputStream = null;
			fileName = file;
			final Properties properties = new Properties();
			if (inputStream == null)
				inputStream = new FileInputStream(new File(fileName));
			properties.load(inputStream);
			userid = properties.getProperty(USERID);
			password = properties.getProperty(PASSWORD);
			driver = properties.getProperty(DRIVER);
			url = properties.getProperty(URL);
			database = properties.getProperty(DATABASE);
		}
		catch (final IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch (final Exception ioe)
		{
			//processException(fileName);
			ioe.printStackTrace();
		}
	}

}
