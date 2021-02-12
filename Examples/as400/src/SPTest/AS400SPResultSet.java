package SPTest;

import java.sql.*;

class AS400SPResultSet {
    Connection con = null;
    long c = 0;

    AS400SPResultSet(String[] args) {
        try {
            Class.forName("com.ibm.as400.access.AS400JDBCDriver");
        } catch (final ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e);
            System.exit(0);
        }

        try {
            con = DriverManager.getConnection("jdbc:as400://185.113.4.88;");
            final long timer1 = System.currentTimeMillis();
            final Statement stmt = con.createStatement();
            if (args[0].equals("carDB")) {
                final CallableStatement pgm = con.prepareCall("call pama.GetCarDB (?, ?, ?)");
                pgm.setString(1, "100000");    //IN

                pgm.registerOutParameter(2, Types.CHAR);    //OUT
                pgm.registerOutParameter(3, Types.CHAR);    //INOUT

                pgm.setString(3, " ");    //INOUT

                try {
                    final ResultSet rs = pgm.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                    }


                } catch (final SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (final SQLException e) {
            System.out.println("SQL error : " + e);
            return;
        }
    }

    public static void main(final String[] pList) {
        new AS400SPResultSet(pList);
        System.exit(0);
    }
}
