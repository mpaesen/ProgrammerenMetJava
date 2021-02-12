/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version v1.00
 * Deze klasse bevat de methodes om gegevens uit de database te onttrekken of ernaartoe te schrijven.
 * De methods zijn static en worden doorheen de gehele applicatie gebruikt om te lezen van en te schrijven naar de database.
 * Deze 2 methods gooien een custom exception per taak, i.p.v. de standaard SQL Exception.
 */

package persistentie;

import exceptions.DataInvoerException;
import exceptions.DataNietGevondenException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBtools 
{
//data members
static Statement stmt = null;
static PreparedStatement ps = null;
static ResultSet rs = null;

/**
 * Method om gegevens weg te schrijven naar de database op basis van een meegegeven query.
 * @param query
 * @throws DataInvoerException
 */
public static void updateTable(String query) throws DataInvoerException 
{
	try 
	{
		stmt = DerbyDB.getConn().createStatement();
		stmt.executeUpdate(query);
	} 
	catch (SQLException e) 
	{
		throw new DataInvoerException();
	}
}
/**
 * Method om gegevens op te vragen van de database op basis van een meegegeven query.
 * @param query
 * @return
 * @throws DataNietGevondenException
 */
public static ResultSet getResultSetFromStatement(String query) throws DataNietGevondenException
{
	try {
		stmt = DerbyDB.getConn().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery(query);
	} catch (SQLException e) 
	{
		throw new DataNietGevondenException();
	}
	return rs;
}
/**
 * Method om het aantal records van een tabel op te vragen.
 * Dit is nodig want er wordt niet met identity op DB-niveau gewerkt om de versatiliteit van de applicatie te verhogen.
 * @param tabelnaam
 * @return
 * @throws DataNietGevondenException
 */
public static int geefAantalRecords(String tabelnaam) throws DataNietGevondenException
{
	int result = 0;
	ResultSet rs = DBtools.getResultSetFromStatement("select * from "+tabelnaam);
	try {
		while (rs.next())
		{
			result += 1;
		}
	} 
	catch (SQLException e) 
	{
		throw new DataNietGevondenException();
	}
	return result;
}
}
