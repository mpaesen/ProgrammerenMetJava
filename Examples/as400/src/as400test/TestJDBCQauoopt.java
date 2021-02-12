package as400test;

import java.sql.*;

public class TestJDBCQauoopt {
	public static void main(String[] args) {
		try {
			//Driver dr =
			// (Driver)Class.forName("AS400JDBCDriver").newInstance();
			DriverManager
					.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());
			Connection con = DriverManager
					.getConnection("jdbc:as400://BEPROI02;naming=SYSTEM");
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("Select * from QAUOOPT");
			while (rs.next()) {

				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\n");
			}
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL problem");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}