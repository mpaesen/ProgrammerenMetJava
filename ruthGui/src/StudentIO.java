import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

 class StudentIO {

     public static Connection getConnection()throws SQLException, ClassNotFoundException{
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("Driver loaded");
         Connection connection = DriverManager.getConnection
                 ("jdbc:mysql://localhost:3306/javabook", "root", "Npngnmtj0");
         return connection;
     }

     public static Statement getStatement() throws SQLException, ClassNotFoundException {
             Statement statement = getConnection().createStatement();
             return statement;
     }
 }

/*

    public static void main(String[] args)   throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/javabook", "root", "Blueviper25051982");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery
                ("select firstName, lastName from Student where lastName "
                        + " = 'Paesen'");
        while (resultSet.next())
            System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2));
    }*/


