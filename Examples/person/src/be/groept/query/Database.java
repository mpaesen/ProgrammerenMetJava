package be.mySchool.query;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

/**
 * 
 * @author Marlo Strouven 
 * maakt verbinding met de database
 * maakt de database aan als er nog geen door de gebruiker gedefinieerde tabellen zijn
 * door een file te lezen met sql statements
 * zorgt voor de uitvoering van de query 
 * geeft het resultaat hiervan terug in html vorm.
 */
public class Database 
{	 private DatabaseMetaData dmd;
	 private PrintWriter pw;
     //private ArrayList<String>htmlTable;
	 //Generics worden pas later ondersteunt.
	 private ArrayList htmlTable;
	 private Statement statement=null;
	 private Connection connection=null;
	 private String driver = "org.apache.derby.jdbc.ClientDriver"; //network server (client) 
	 private String protocol = "jdbc:derby://localhost/";
	 private Properties props;

public Database(){
	
	try{
	
		Class.forName(driver).newInstance();	    
		props=new Properties();
		String user="app";
		props.put("user",user);
		props.put("password", "app");
		connection=DriverManager.getConnection(protocol +
                "d:\\cloudscape_db\\BooksDB;create=true");
	    
		//nakijken of de database al aangemaakt is anders createDatabase();
		dmd=connection.getMetaData();
		ResultSet mrs=dmd.getTables(null, null, null, null);
		boolean maken=true;
		//er zijn geen aangemaakte tabellen door de user als TABLE_SCHEM != user
		//for(String str:this.displayHTML(mrs)){
		ArrayList temp=displayHTML(mrs);
		Iterator it=temp.iterator();
	
		while(it.hasNext()){
			String str=(String)it.next();
			if(str.toUpperCase().contains(user.toUpperCase())){
				//System.out.println(str);
				maken=false;
				break;
			}
		}
		if(maken){
			this.createDatabase();
		}		
		System.out.println("Connected to and created database Books");
	    //connection.setAutoCommit(false);
	}
	catch(Throwable e){
		System.out.println("exception thrown:");
		if(e instanceof SQLException){
			printSQLError((SQLException) e);		
		}
		else{
			e.printStackTrace();
		}			
	}	 
}
/**
 * maakt de database aan door een file te lezen met SQL statements
 */
public void createDatabase() throws SQLException{
	System.out.println("hij leest de file createdatabase");
	Statement stat=connection.createStatement();
	StringBuffer lines=new StringBuffer();
	try{
		BufferedReader in=new BufferedReader(new FileReader("d:\\cloudscape_db\\CreateDatabaseBooks.txt"));
		
		String regel;
		while((regel=in.readLine())!=null){
	
			if(regel.contains(";")){
				String temp=regel.replace(';', ' ');
				lines.append(temp+" ");
				stat.executeUpdate(lines.toString());
				lines=new StringBuffer();
			}
			else{				
				lines.append(regel+" ");
			}
		}
		in.close();
	}
    catch(FileNotFoundException e){
    	e.printStackTrace(); 	
    }
    catch(IOException ioe){
    	ioe.printStackTrace();
    }
    stat.close();
   }
static void printSQLError(SQLException e)
{
    while (e != null)
    {
        System.out.println(e.toString());
        e = e.getNextException();
    }
}
/**
 * 
 * @param query (String)
 * @param pw	(PrintWriter)
 * @return	String (resultatentabel in html formaat)
 * @throws SQLException
 */
public String executeQuery(String query,PrintWriter pw)
      throws SQLException{
	this.pw=pw;
	statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	ResultSet rs=null;
	boolean hasResult=false;
	try{
     hasResult=statement.execute(query);
     if(hasResult){	 
    	 rs=statement.getResultSet();
     }
	}
	catch(SQLException e){
		if(pw!=null){
			e.printStackTrace(pw);
		}
		else{
			e.printStackTrace();		
		}
	}	
	StringBuffer s=new StringBuffer();
	if(hasResult){	
    s.append("<Html><Head><Title>resultset</title></Head><body>");
    
    
    
 	//for(String str:displayHTML(rs)){
    ArrayList temp=displayHTML(rs);
	Iterator it=temp.iterator();

	while(it.hasNext()){
        String str=(String)it.next();
 		s.append(str);
 	}   
    s.append("</body></html>");
	}
	statement.close();
	//connection.close(); Cannot close a connection while a transaction is still active.
	
 	return s.toString();
}

/** 
 * geeft het resultaat van de query terug in html vorm.
 * @param rs ResultSet
 * @return ArrayList<String>
 */

public ArrayList displayHTML(ResultSet rs){
	try{
		//rs.first();
		htmlTable=new ArrayList();
		ResultSetMetaData rsmd = rs.getMetaData();
		int numberOfColumns = rsmd.getColumnCount();
		htmlTable.add("<table border>");
		htmlTable.add("<tr>");
		for(int i=1;i<=numberOfColumns;i++){
			htmlTable.add("<td>"+rsmd.getColumnName(i)+"</td>");
		}
		htmlTable.add("</tr>");
		while(rs.next()){
		htmlTable.add("<tr>");
        for(int i=1;i<=numberOfColumns;++i){
        	htmlTable.add("<td>"+rs.getString(i)+"</td>");
        }
        htmlTable.add("</tr>");
        }
	    htmlTable.add("</table>");	     
	} 
	catch(SQLException sqlex){
		if(pw!=null){
			sqlex.printStackTrace(pw);
		}
		else{
			sqlex.printStackTrace();
		}
	}
	return htmlTable;
}
/*
public ArrayList<String> displayHTML(ResultSet rs){	
	try{
		//rs.first();
		htmlTable=new ArrayList<String>();
		ResultSetMetaData rsmd = rs.getMetaData();
		int numberOfColumns = rsmd.getColumnCount();
		htmlTable.add("<table border>");
		htmlTable.add("<tr>");
		for(int i=1;i<=numberOfColumns;i++){
			htmlTable.add("<td>"+rsmd.getColumnName(i)+"</td>");
		}
		htmlTable.add("</tr>");
		while(rs.next()){
		htmlTable.add("<tr>");
        for(int i=1;i<=numberOfColumns;++i){
        	htmlTable.add("<td>"+rs.getString(i)+"</td>");
        }
        htmlTable.add("</tr>");
        }
	    htmlTable.add("</table>");	     
	} 
	catch(SQLException sqlex){
		if(pw!=null){
			sqlex.printStackTrace(pw);
		}
		else{
			sqlex.printStackTrace();
		}
	}
	return htmlTable;
}
*/
public void close(){
    try{
	connection.close();
    }
    catch(SQLException sqle){
    	sqle.printStackTrace(pw);
    }
}
}
