/**
 * @author Kjell Lenaers
 * @version v1.01
 * Deze klasse bevat SelectItemcollecties die doorheen de applicatie gebruikt worden in Selecteermenu's.
 * Deze menu's komen doorheen de hele applicatie voor zodat er snel bepaalde klanten, calls,... geselecteerd
 * kunnen worden, waarvan de gegevens afkomstig zijn uit de database.
 * Zo worden er met behulp van enkele kliks enkel bestaande gegevens ingegeven 
 * en loopt er niets mis op database-niveau d.m.v. foreign key constraints.
 */

package persistentie;

import exceptions.DataNietGevondenException;
import model.Gebruiker;
import model.KlachtType;
import model.Klant;

import javax.faces.model.SelectItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectItems 
{
	ResultSet rs;	

	SelectItem[] klanten;

	SelectItem[] gebruikers;

	SelectItem[] calls;

	public SelectItem[] getklanten() throws DataNietGevondenException 
	{
		List<SelectItem> klantLijst = new ArrayList<SelectItem>();
		try
		{
			rs = DBtools.getResultSetFromStatement("select * from klanten");
			while (rs.next())
			{
				klantLijst.add(new SelectItem(rs.getInt("klantid")+ " " +rs.getString("klantnaam")));
			}
		}
		catch (SQLException e)
		{
			throw new DataNietGevondenException();
		}
		return (SelectItem[])klantLijst.toArray(new SelectItem[0]);
	}

	public SelectItem[] getGebruikers() throws DataNietGevondenException 
	{
		List<SelectItem> gebruikerLijst = new ArrayList<SelectItem>();
		try
		{
			rs = DBtools.getResultSetFromStatement("select * from gebruikers");
			while (rs.next())
			{
				gebruikerLijst.add(new SelectItem(rs.getInt("id")+" "+rs.getString("gebruikersnaam")));
			}
		}
		catch (SQLException e)
		{
			throw new DataNietGevondenException();
		}
		return (SelectItem[])gebruikerLijst.toArray(new SelectItem[0]);
	}

	public SelectItem[] getCalls() throws DataNietGevondenException 
	{
		List<SelectItem> callLijst = new ArrayList<SelectItem>();
		try
		{
			rs = DBtools.getResultSetFromStatement("select * from studenten");
			Gebruiker g;
			Klant k;
			while (rs.next())
			{
				g = new Gebruiker(rs.getInt("gebruikerID"));
				k = new Klant(rs.getInt("klantID"));
				callLijst.add(new SelectItem(rs.getInt("callid")+" "+g.getGebruikerNaam()+" "+k.getKlantNaam() + " "+rs.getString("datum")+" "+rs.getString("klachttype")));
			}
		}
		catch (SQLException e)
		{
			throw new DataNietGevondenException();
		}
		return (SelectItem[])callLijst.toArray(new SelectItem[0]);
	}

	public SelectItem[] getKlachtTypes()
	{
		List<SelectItem> klachtTypeLijst = new ArrayList<SelectItem>();
		for (KlachtType k : KlachtType.values())
		{
			klachtTypeLijst.add(new SelectItem(k.getType()));
		}
		return (SelectItem[])klachtTypeLijst.toArray(new SelectItem[0]);
	}
}
