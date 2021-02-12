/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version v1.00
 * Deze klasse bevat de gegevens voor de connectie met de database.
 * De modifiers static en final zorgen ervoor dat deze klasse maar een keer geïnitialiseerd kan worden 
 * en deze klasse wordt doorheen de gehele applicatie gebruikt.
 */
package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DerbyDB 
{
	
	private final static String DBURL = "jdbc:derby://localhost:1527/CallCenter;user=APP;password=APP;create=true";
	private static Connection conn = null;
	
	public static Connection getConn() 
	{
		if (conn == null) 
		{
		try
	        {
				//Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				Class.forName("org.apache.derby.jdbc.ClientDriver");
	            conn = DriverManager.getConnection(DBURL); 
	        }
	        catch (Exception except)
	        {
	            except.printStackTrace();
	        }
	    }
		return conn;
	}
	}
