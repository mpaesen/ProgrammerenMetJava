//TestJDBC
package com.ibm.jdbc;

//package as400test;

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
				"jdbc:as400://as400tst/;");
		//�Toolbox driver: "jdbc:as400://system-name"
		//�Toolkit driver: "jdbc:db2://system-name"
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		rmd = rs.getMetaData();
		columns = new String[rmd.getColumnCount()];
		columnTypes = new String[rmd.getColumnCount()];
		

	}

	public String column(int i) throws SQLException {
		
		if (columnTypes[i - 1].equals("CHAR"))
			return rs.getString(i);
		if (columnTypes[i - 1].equals("DECIMAL"))
			return rs.getBigDecimal(i).toString();
		if (columnTypes[i - 1].equals("INTEGER"))
			return Integer.toString(rs.getInt(i));
		if (columnTypes[i - 1].equals("NUMERIC"))
			return rs.getString(i);
		if (columnTypes[i - 1].equals("TIMESTAMP"))
			return rs.getString(i);			
		if (columnTypes[i - 1].equals("VARCHAR"))
			return rs.getString(i);			
		if (columnTypes[i - 1].equals("DATE"))
			return rs.getString(i);			
	
			return " ";
	
	}

	private String columnHeaders() throws SQLException {
                StringBuffer kolommen = new StringBuffer();
                StringBuffer lineBuffer = new StringBuffer();
		for (int i = 0; i < rmd.getColumnCount(); i++) {
			kolommen.append(rmd.getColumnName(i + 1));

			size = getSize(i);
			lineBuffer.append(printLine(size));
			
			for (int j = 0;
				j < size - rmd.getColumnName(i + 1).trim().length();
				j++) {
				kolommen.append(" ");
			}
			columns[i] = rmd.getColumnName(i + 1);
			columnTypes[i] = rmd.getColumnTypeName(i + 1);
		}

		return lineBuffer.toString()+"\n"+ kolommen.toString();

	}


	private String columnTypes() throws SQLException {
		StringBuffer myTypes= new StringBuffer();
		StringBuffer lineBuffer = new StringBuffer();
		for (int i = 0;	i < rmd.getColumnCount();i++)  {
				myTypes.append(columnTypes[i]);
				
				size = getSize(i);
				lineBuffer.append(printLine(size));
				for (int j = 0;
				j < size - rmd.getColumnTypeName(i + 1).trim().length();
				j++) {
				myTypes.append(" ");
			}
			}		
		return lineBuffer.toString()+"\n"+ myTypes.toString();
	}

	private String printLine(int size) {
		StringBuffer buffer = new StringBuffer();
		for(int j = 0; j< size; j++){
			buffer.append("-");
		}
		return buffer.toString();
	}

	private int getSize(int i) throws SQLException {
		return 	Math.max(
				rmd.getColumnDisplaySize(i + 1),
				rmd.getColumnName(i + 1).length())
				+ 2;
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
			size = getSize(i);
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
			
			
			System.out.println(file.columnHeaders());
			file.printRecordDetails();

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
