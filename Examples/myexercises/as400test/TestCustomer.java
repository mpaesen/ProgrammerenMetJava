package as400test;
import java.sql.*;

public class TestCustomer {
    public static void main(String[] args) {
        try {
            //Driver dr = (Driver)Class.forName("AS400JDBCDriver").newInstance();
            DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());
	        Connection con = DriverManager.getConnection("jdbc:as400://BEPROI02/PAMA;naming=sql;errors=full;dateformat=iso;extended dynamic=true;package=JDBCEX;package library=PAMA,PAMA");        
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("Select * from PAMA.CUSTMAST");
            while (rs.next()) {
                System.out.print(rs.getInt("nbr") + "\t");
                System.out.print(rs.getString("name") + "\t");
                System.out.print(rs.getString("addr") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL problem");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
