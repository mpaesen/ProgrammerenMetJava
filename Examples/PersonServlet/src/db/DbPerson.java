// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DbPerson.java

package db;

import model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbPerson
{

    public DbPerson()
    {
        driver = "org.apache.derby.jdbc.ClientDriver";
        //dbName = "PersonDb";
        dbName = "c:\\cloudscape_db\\addressDB";
        connectionURL = (new StringBuilder("jdbc:derby://localhost:1527/")).append(dbName).toString();
        conn = null;
    }

    public static DbPerson getInstance()
    {
        return new DbPerson();
    }

    public void open()
        throws Exception
    {
        try
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(connectionURL);
        }
        catch(SQLException e)
        {
            throw e;
        }
        catch(ClassNotFoundException e)
        {
            Exception ex = new Exception((new StringBuilder("Kan database driver niet vinden: '")).append(driver).append("'").toString());
            throw ex;
        }
        catch(Exception e)
        {
            throw e;
        }
    }

    public void close()
        throws Exception
    {
        try
        {
            if(!conn.isClosed())
                conn.close();
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

    public List getPersons()
    {
        try
        {
            List listOfPersons = new ArrayList();
            String sqlSelect = "select * from Person ORDER BY name";
            if(!conn.isClosed())
            {
                Statement sqlStatement = conn.createStatement();
                ResultSet sqlResult;
                Person person;
                for(sqlResult = sqlStatement.executeQuery(sqlSelect); sqlResult.next(); listOfPersons.add(person))
                {
                    int id = sqlResult.getInt("id");
                    String name = sqlResult.getString("name");
                    String street = sqlResult.getString("street");
                    String postcode = sqlResult.getString("postcode");
                    String city = sqlResult.getString("city");
                    String gsm = sqlResult.getString("gsm");
                    String email = sqlResult.getString("email");
                    person = new Person(id, name, street, postcode, city, gsm, email);
                }

                sqlResult.close();
                sqlStatement.close();
            }
            return listOfPersons;
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    public void createPerson(String name, String street, String postcode, String city, String gsm, String email)
        throws Exception
    {
        try
        {
            String sqlInsert = "Insert Into Person(name, street, postcode, city, gsm, email)values (?,?,?,?,?,?)";
            if(!conn.isClosed())
            {
                PreparedStatement sqlStatement = conn.prepareStatement(sqlInsert);
                sqlStatement.setString(1, name);
                sqlStatement.setString(2, street);
                sqlStatement.setString(3, postcode);
                sqlStatement.setString(4, city);
                sqlStatement.setString(5, gsm);
                sqlStatement.setString(6, email);
                sqlStatement.executeUpdate();
                sqlStatement.close();
            }
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

    private String driver;
    private String dbName;
    private String connectionURL;
    private Connection conn;
}
