//TestJDBC

package as400test;

import com.ibm.as400.access.*;

import java.sql.*;

public class TestJDBC {
	private String columns[];
	private String columnTypes[];
	private Connection con;
	private StringBuffer kolommen;
	private PreparedStatement pstmt;
	private ResultSetMetaData rmd;
	private ResultSet rs;

	private int size;
	
	public TestJDBC(String sql) throws SQLException {
		DriverManager.registerDriver(new AS400JDBCDriver());
		con =
			DriverManager.getConnection(
				"jdbc:as400://185.113.4.88/workshop");
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		rmd = rs.getMetaData();
		columns = new String[rmd.getColumnCount()];
		columnTypes = new String[rmd.getColumnCount()];
		kolommen = new StringBuffer();

	}

	public String column(int i) throws SQLException {
		String col = "";
		if (columnTypes[i - 1].equals("CHAR"))
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

	private String columnHeaders() throws SQLException {

		for (int i = 0; i < rmd.getColumnCount(); i++) {
			kolommen.append(rmd.getColumnName(i + 1));

			getSize(i);
			for (int j = 0;
				j < size - rmd.getColumnName(i + 1).trim().length();
				j++) {
				kolommen.append(" ");
			}
			columns[i] = rmd.getColumnName(i + 1);
			columnTypes[i] = rmd.getColumnTypeName(i + 1);
		}

		return kolommen.toString();

	}

	private void getSize(int i) throws SQLException {
		size =
			Math.max(
				rmd.getColumnDisplaySize(i + 1),
				rmd.getColumnName(i + 1).length())
				+ 1;
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

	private void close() {
		try {
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String args[]) {
		System.out.println("Inside TestJDBC");
		TestJDBC file = null;
		try {
			String sql = null;
			if (args.length == 0){
			
				sql = "select * from QGPL.QAUOOPT";
			}else {
				sql = args[0];
			}
			file = new TestJDBC(sql);

			System.out.println(
				"-----------------------------------------------------------------------");
			System.out.println(file.columnHeaders());
			file.printRecordDetails();
			System.out.println(
				"-----------------------------------------------------------------------");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("An SQL Exception occurred");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			file.close();
		}
		System.exit(0);
	}

}
