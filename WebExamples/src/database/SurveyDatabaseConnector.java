package database;

import java.sql.*;

public final class SurveyDatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/survey?characterEncoding=utf8";
    private static final String USERNAME = "Mathy";
    private static final String PASSWORD = "Npngnmtj0";

    private Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    ;
    private PreparedStatement updateData;

    private Statement s = connection.createStatement();
    private ResultSet rs;

    public SurveyDatabaseConnector() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            updateData = connection.prepareStatement(
                    "UPDATE animalSurvey " +
                            "SET votes = votes + 1 " +
                            "WHERE animalID = ?");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public ResultSet getRs() throws SQLException {
        return s.executeQuery("SELECT * FROM animalSurvey");
    }

    public Connection getConnection() {
        return connection;
    }

    public int updateData(int id) {
        try {
            updateData.setInt(1, id);

            return updateData.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return 0;
        }
    }
}