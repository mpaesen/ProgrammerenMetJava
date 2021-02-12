/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.00
 * Deze klasse houdt de informatie bij van de huidig ingelogde gebruiker en wordt doorheen de applicatie gebruikt.
 * (Invoeren van calls, machtigingen,...)
 */

package model;

import exceptions.DataNietGevondenException;

public final class HuidigeGebruiker 
{
//datamember
private static Gebruiker huidigeGebruiker;
//getter en setter

public static Gebruiker getHuidigeGebruiker() 
{
	return huidigeGebruiker;
}

public static Gebruiker setHuidigeGebruiker(String gebruikersnaam) throws DataNietGevondenException
{
	huidigeGebruiker = new Gebruiker(gebruikersnaam);
	return huidigeGebruiker;
}

}
