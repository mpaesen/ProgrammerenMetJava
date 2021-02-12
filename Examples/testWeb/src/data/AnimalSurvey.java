package data;

import java.sql.*;
import java.util.Properties;

/*
 * (C) Copyright IBM Corp. 2001, 2004.
 *
 * The source code for this program is not published or otherwise divested
 * of its trade secrets, irrespective of what has been deposited with the
 * U.S. Copyright Office.
 */

public class AnimalSurvey {

	// public String framework = "embedded";
	public String framework = "client";
	// public String driver = "org.apache.derby.jdbc.EmbeddedDriver"; // single
	// connection
	// (stand
	// alone)
	public String driver = "org.apache.derby.jdbc.ClientDriver"; // network
	// server (client)
	public String protocol = "jdbc:derby:"; //
	// public String protocol = "jdbc:derby:";
	// jdbc:derby://brxn1smpn:1527/c:\cloudscape_db\animalsurvey
	private StringBuffer kolommen;
	private ResultSetMetaData rmd;
	private ResultSet rs;
	private Statement s;
	private Properties props;
	private Connection conn = null;
	private int size;
	private String columns[];
	private String columnTypes[];

	public AnimalSurvey(String[] args) {
		/* parse the arguments to determine which framework is desired */
		parseArguments(args);

		System.out.println("AnimalSurvey starting in " + framework + " mode.");

		try {
			/*
			 * The driver is installed by loading its class. In an embedded
			 * environment, this will start up Derby, since it is not already
			 * running.
			 */
			Class.forName(driver).newInstance();
			System.out.println("Loaded the appropriate driver.");

			props = new Properties();
			props.put("user", "app");
			props.put("password", "app");

			/*
			 * The connection specifies create=true to cause the database to be
			 * created. To remove the database, remove the directory
			 * animalsurvey and its contents. The directory animalsurvey will be
			 * created under the directory that the system property
			 * derby.system.home points to, or the current directory if
			 * derby.system.home is not set.
			 */
			conn = DriverManager.getConnection(protocol
					+ "c:\\cloudscape_db\\animalsurvey;create=true", props);

			System.out
					.println("Connected to and created database animalsurvey");

			conn.setAutoCommit(false);

			/*
			 * Creating a statement lets us issue commands against the
			 * connection.
			 */
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

	void go() throws SQLException {

		try {
			s.execute("drop table surveyresults");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		/*
		 * We create a table, add a few rows, and update one.
		 */
		s
				.execute("create table surveyresults (id int NOT NULL , surveyoption varchar (20) NOT NULL , votes int NOT NULL , constraint surveyresults_id primary key (id)) ");
		s
				.execute("insert into surveyresults (id,surveyoption,votes) values (1, 'Dog', 0)");
		s
				.execute("insert into surveyresults (id,surveyoption,votes) values (2, 'Cat', 0)");
		s
				.execute("insert into surveyresults (id,surveyoption,votes) values (3, 'Bird', 0)");
		s
				.execute("insert into surveyresults (id,surveyoption,votes) values (4, 'Snake', 0)");
		s
				.execute("insert into surveyresults (id,surveyoption,votes) values (5, 'None', 0)");
		/*
		 * We select the rows and verify the results.
		 */
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

		System.out.println("AnimalSurvey finished");
	}

	static void printSQLError(SQLException e) {
		while (e != null) {
			System.out.println(e.toString());
			e = e.getNextException();
		}
	}

	private void parseArguments(String[] args) {
		int length = args.length;

		for (int index = 0; index < length; index++) {
			if (args[index].equalsIgnoreCase("jccjdbcclient")) {
				framework = "jccjdbc";
				// driver = "com.ibm.db2.jcc.DB2Driver";
				// protocol = "jdbc:derby:net://localhost:1527/";
				driver = "org.apache.derby.jdbc.ClientDriver";
				protocol = "jdbc:derby://localhost:1527/";
				// jdbc:derby://brxn1smpn:1527/c:\cloudscape_db\animalsurvey
			}
		}
	}

	public static void main(String[] args) {
		AnimalSurvey table = new AnimalSurvey(args);
		try {
			table.go();
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
