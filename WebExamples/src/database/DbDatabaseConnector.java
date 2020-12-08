package database;

import java.sql.*;

public final class DbDatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/classicmodels?characterEncoding=utf8";
    private static final String USERNAME = "Mathy";
    private static final String PASSWORD = "Npngnmtj0";

    private Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    private Statement s = connection.createStatement();


    public DbDatabaseConnector() throws SQLException {
    }

    public ResultSet getRs(String table) throws SQLException {
        return s.executeQuery("SELECT * FROM " + table);
    }

    public Connection getConnection() {
        return connection;
    }

}
