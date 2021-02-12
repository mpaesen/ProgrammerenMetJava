package data;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Hashtable;
import java.util.Properties;

public class TableSelectDS {
	/* the default framework is embedded */
	public String framework = "embedded";

	public String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static String initialContextFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";
	public String protocol = "jdbc:derby:";
	private static String lookupURL = "iiop:///";
	private static String lookupName = "jdbc/books";
	public String location = "c:\\cloudscape_db\\";
	private static String user = "USERID";
	private static String password = "PASSWORD";
	private StringBuffer kolommen;

	private ResultSetMetaData rmd;

	private ResultSet rs;

	private Statement s;

	private Properties props;

	private Connection conn = null;

	private DataSource dataSource;

	private static String jndiName = null;

	private int size;

	private String columns[];

	private String columnTypes[];

	public TableSelectDS(String[] args) {
		/* parse the arguments to determine which framework is desired */

		System.out.println("Table Select starting in " + framework + " mode.");

		try {
			// webSphere
			conn = getConnection();
			conn.setAutoCommit(false);
			s = conn.createStatement();
		} catch (Throwable e) {
			System.out.println("exception thrown:");

			if (e instanceof SQLException) {
				printSQLError((SQLException) e);
			} else {
				e.printStackTrace();
			}
		}

	}

	// Tomcat
	public static Connection getConnection() {

		try {
			InitialContext initContext = new InitialContext();
			Context envCtx = (Context) initContext.lookup("java:comp/env");
			String DATASOURCE_NAME = "java:comp/env/jdbc/books";
			javax.sql.DataSource dataSource = (DataSource) envCtx
					.lookup(DATASOURCE_NAME);
			return dataSource.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// WebSphere
	public static Connection getConnection(String lookupName) {

		InitialContext ctx = null;
		Hashtable parms = new Hashtable();
		parms.put(Context.INITIAL_CONTEXT_FACTORY, initialContextFactory);
		parms.put(Context.PROVIDER_URL, lookupURL);
		javax.sql.DataSource ds = null;

		try {
			ctx = new InitialContext(parms);

			ds = (javax.sql.DataSource) ctx.lookup(lookupName);
			return ds.getConnection(user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String column(int i) throws SQLException {
		String col = "";
		if (columnTypes[i - 1].equals("CHAR"))
			col = rs.getString(i);
		if (columnTypes[i - 1].equals("VARCHAR"))
			col = rs.getString(i);
		if (columnTypes[i - 1].equals("DECIMAL"))
			col = rs.getBigDecimal(i).toString();
		if (columnTypes[i - 1].equals("INTEGER"))
			col = Integer.toString(rs.getInt(i));
		if (columnTypes[i - 1].equals("TIMESTAMP"))
			col = rs.getString(i);
		if (col == null)
			col = " ";
		return col;
	}

	private void getSize(int i) throws SQLException {
		size = Math.max(rmd.getColumnDisplaySize(i + 1), rmd.getColumnName(
				i + 1).length()) + 1;
	}

	private String columnHeaders() throws SQLException {
		kolommen = new StringBuffer();
		columns = new String[rmd.getColumnCount()];
		columnTypes = new String[rmd.getColumnCount()];

		for (int i = 0; i < rmd.getColumnCount(); i++) {
			kolommen.append(rmd.getColumnName(i + 1));

			getSize(i);
			for (int j = 0; j < size - rmd.getColumnName(i + 1).trim().length(); j++) {
				kolommen.append(" ");
			}

			columns[i] = rmd.getColumnName(i + 1);
			columnTypes[i] = rmd.getColumnTypeName(i + 1);
		}

		return kolommen.toString();

	}

	private void printRecordDetails() throws SQLException {

		while (rs.next()) {
			System.out.print(recordDetails());
		}

	}

	private String recordDetails() throws SQLException {
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < rmd.getColumnCount(); i++) {
			output.append(column(i + 1).trim());
			getSize(i);
			for (int j = 0; j < size - column(i + 1).trim().length(); j++) {
				output.append(" ");
			}
		}
		output.append("\n");
		return output.toString();
	}

	void go(String[] args) throws SQLException {

		/*
		 * We select the rows and verify the results.
		 */
		if (args.length != 0)
			rs = s.executeQuery("SELECT * FROM " + args[1]);
		else
			rs = s
					.executeQuery("SELECT * FROM surveyresults ORDER BY surveyoption");
		rmd = rs.getMetaData();

		System.out
				.println("-----------------------------------------------------------------------");
		System.out.println(columnHeaders());
		printRecordDetails();
		System.out
				.println("-----------------------------------------------------------------------");

		/*
		 * We release the result and statement resources.
		 */
		rs.close();
		s.close();
		System.out.println("\nClosed result set and statement");

		/*
		 * We end the transaction and the connection.
		 */
		conn.commit();
		conn.close();
		System.out.println("Committed transaction and closed connection");

		/*
		 * In embedded mode, an application should shut down Derby. If the
		 * application fails to shut down Derby explicitly, the Derby does not
		 * perform a checkpoint when the JVM shuts down, which means that the
		 * next connection will be slower. Explicitly shutting down Derby with
		 * the URL is preferred. This style of shutdown will always throw an
		 * "exception".
		 */
		boolean gotSQLExc = false;

		if (framework.equals("embedded")) {
			try {
				DriverManager.getConnection("jdbc:derby:;shutdown=true");
			} catch (SQLException se) {
				gotSQLExc = true;
			}

			if (!gotSQLExc) {
				System.out.println("Database did not shut down normally");
			} else {
				System.out.println("Database shut down normally");
			}
		}

		System.out.println("TableSelect finished");
	}

	static void printSQLError(SQLException e) {
		while (e != null) {
			System.out.println(e.toString());
			e = e.getNextException();
		}
	}

	public static void main(String[] args) {
		TableSelectDS table = new TableSelectDS(args);
		try {
			table.go(args);
		} catch (Throwable e) {
			System.out.println("exception thrown:");

			if (e instanceof SQLException) {
				printSQLError((SQLException) e);
			} else {
				e.printStackTrace();
			}
		}
	}
}