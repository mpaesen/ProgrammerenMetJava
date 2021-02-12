/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse (bean) voegt een call toe aan de database.
 */

package model;

import exceptions.DataInvoerException;
import exceptions.DataNietGevondenException;
import my.tools.Datum;
import persistentie.DBtools;

import java.text.ParseException;

public class CallToevoegen 
{
	//datamembers
	String klant;//uit jsf-inputveld
	String klachtType;//uit jsf-inputveld
	String klachtBeschrijving;//uit jsf-inputveld
	String klachtToestel;//uit jsf-inputveld
	
	//getters en setters
	public String getKlant() {
		return klant;
	}
	public void setKlant(String klant) {
		this.klant = klant;
	}
	public String getKlachtType() {
		return klachtType;
	}
	public void setKlachtType(String klachtType) {
		this.klachtType = klachtType;
	}
	public String getKlachtBeschrijving() {
		return klachtBeschrijving;
	}
	public void setKlachtBeschrijving(String klachtBeschrijving) {
		this.klachtBeschrijving = klachtBeschrijving;
	}
	public String getKlachtToestel() {
		return klachtToestel;
	}
	public void setKlachtToestel(String klachtToestel) {
		this.klachtToestel = klachtToestel;
	}
	/**
	 * Method om een call toe te voegen aan de database
	 * @return
	 * @throws DataInvoerException
	 * @throws DataNietGevondenException 
	 */
	public String callToevoegen() throws DataInvoerException, DataNietGevondenException
	{
		Datum datum = new Datum();
		try 
		{
			DBtools.updateTable("insert into table calls (callid, gebruikerid, klantid, status, datum, klachttoestel,klachttype, klachtbeschrijving)" +
					"values ("+(DBtools.geefAantalRecords("calls")+1)+","+HuidigeGebruiker.getHuidigeGebruiker().gebruikerID+","+
					klant.substring(0,klant.indexOf(" "))+",1,'"+datum.getDatumInAmerikaansFormaat()+"','"+klachtToestel+"','"+klachtType+"','"+klachtBeschrijving+"')");
		} 
		catch (ParseException e) 
		{
			throw new DataInvoerException();
		}
		return "callToegevoegd";
	}
}
