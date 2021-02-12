//TestJDBC

package test;

import com.ibm.as400.access.*;

import java.sql.*;

public class TableMetaData {
	private String columns[];
	private String columnTypes[];
	private Connection con;
	
	private PreparedStatement pstmt;
	private ResultSetMetaData rmd;
	private ResultSet rs;

	private int size;
	
	public TableMetaData(String sql) throws SQLException {
		DriverManager.registerDriver(new AS400JDBCDriver());  //Toolbox
/*		DriverManager.registerDriver(
		new com.ibm.as400.access.AS400JDBCDriver());   
		  or new com.ibm.db2.jdbc.app.DB2Driver());  //Toolkit 
*/
		con =
			DriverManager.getConnection(
				"jdbc:as400://AMBIORIX/;naming=sql;errors=full;dateformat=iso;extended dynamic=true;package=JDBCEX;package library=QGPL");
		//�Toolbox driver: "jdbc:as400://system-name"
		//�Toolkit driver: "jdbc:db2://system-name"
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		rmd = rs.getMetaData();
		columns = new String[rmd.getColumnCount()];
		columnTypes = new String[rmd.getColumnCount()];
		

	}

	public String column(int i) throws SQLException {
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

	private String columnHeaders() throws SQLException {
                StringBuffer kolommen = new StringBuffer();
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

	private String columnTypes() throws SQLException {
		StringBuffer myTypes= new StringBuffer();
		for (int i = 0;	i < rmd.getColumnCount();i++)  {
				myTypes.append(columnTypes[i]);
				
				getSize(i);
				for (int j = 0;
				j < size - rmd.getColumnTypeName(i + 1).trim().length();
				j++) {
				myTypes.append(" ");
			}
			}		
		return myTypes.toString();
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
		TableMetaData file = null;
		try {
			String sql = null;
			if (args.length == 0){
			
				sql = "select * from QGPL.QAUOOPT";
			}else {
				sql = args[0];
			}
			file = new TableMetaData(sql);
			
			System.out.println(
				"-----------------------------------------------------------------------");
			System.out.println(file.columnHeaders());
			file.printRecordDetails();
			System.out.println(
				"-----------------------------------------------------------------------");
			System.out.println(file.columnTypes());				

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
