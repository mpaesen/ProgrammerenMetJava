package creational.singleton.dbMirror;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBMirror {
    private static final int MAX = 10;
    private static final String CONFIGURATION_URL = "../data/database.properties";
    private static Connection master;
    private static Connection slave;
    private static ArrayList<Person> list = new ArrayList<>();
    private static PreparedStatement preparedStatement = null;
    private static Person person;

    public static void main(String[] args) {
        File file = new File(CONFIGURATION_URL);
        list = RandomGenerator.getList(MAX);
        try {
            ConfigureDatabase.configureDatabases(file);
            persistListData(ConfigureDatabase.getMaster(), list);
            persistListData(ConfigureDatabase.getSlave(), list);
            person = RandomGenerator.getPerson();
            insertOnePerson(ConfigureDatabase.getMaster(), person);
            insertOnePerson(ConfigureDatabase.getSlave(), person);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private static void persistListData(final Connection database, final ArrayList<Person> list) throws SQLException {
        insertListIntoDatabase(database, list);
    }

    private static void insertListIntoDatabase(Connection database, final ArrayList<Person> list) throws SQLException {
        String sqlStatement = "insert into person values(default, ?, ?)";
        preparedStatement = database.prepareStatement(sqlStatement);
        Person person;
        for (int i = 0; i < list.size(); i++) {
            person = list.get(i);
            //preparedStatement.setString(1, default);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.execute();
        }
        preparedStatement.close();
    }

    private static void insertOnePerson(Connection database, Person person) throws SQLException {
        String sqlStatement = "insert into person values(default, ?, ?)";
        preparedStatement = database.prepareStatement(sqlStatement);
        //preparedStatement.setString(1, default);
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFirstName());
        preparedStatement.execute();
        preparedStatement.close();
    }
}


