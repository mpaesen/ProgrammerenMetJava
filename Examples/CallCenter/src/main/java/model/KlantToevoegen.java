/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse (bean) voegt een klant toe aan de database.
 */

package model;

import exceptions.DataInvoerException;
import exceptions.DataNietGevondenException;
import persistentie.DBtools;

public class KlantToevoegen 
{
private String klantNaam;//uit jsf-inputveld

public void setKlantNaam(String klantNaam) {
	this.klantNaam = klantNaam;
}

public String getKlantNaam() {
	return klantNaam;
}
public String klantToevoegen() throws DataInvoerException, DataNietGevondenException
{
DBtools.updateTable("insert into table klanten values ("+(DBtools.geefAantalRecords("klanten")+1)+",'"+klantNaam+"')");
return "KlantToegevoegd";	
}
}
