/**
 * @author Kjell Lenaers, Pieter Vanderbist
 * @version 1.01
 * Deze klasse zorgt ervoor dat de klantentabel en de gebruikerstabel (operators & managers) gevuld worden
 * met data.
 * Deze methods worden aangesproken via de Testklasse in de package test om zo snel data te kunnen genereren.
 */

package persistentie.test;

import exceptions.DataInvoerException;
import exceptions.DataNietGevondenException;
import my.tools.Generators;
import persistentie.DBtools;

import java.util.Random;

public class MaakTestData 
{
Random r = new Random();
Generators g = new Generators();

/**
 * Deze method maakt een klant aan met een id en een klantnaam.
 * De id wordt zelf berekend uit het aantal bestaande records en niet via identity. Dit is om het updaten
 * met behoud van id later gemakkelijker te kunnen implementeren.
 * @throws DataInvoerException
 * @throws DataNietGevondenException
 */
public void maakKlant() throws DataInvoerException, DataNietGevondenException
{
DBtools.updateTable("insert into klanten values ("+(DBtools.geefAantalRecords("klanten")+1)+",'"+g.generateName()+"')");
}

/**
 * Deze method maakt het gespecifieerde aantal klanten aan.
 * @param aantal
 * @throws DataInvoerException
 * @throws DataNietGevondenException
 */
public void maakKlanten(int aantal) throws DataInvoerException, DataNietGevondenException
{
	for (int i = 0; i < aantal; i++)
	{
		maakKlant();	
	}
}

/**
 * Deze method maakt een gebruiker aan met een gebruikerid en een klantnaam.
 * De id wordt zelf berekend uit het aantal bestaande records en niet via identity. Dit is om het updaten
 * met behoud van id later gemakkelijker te kunnen implementeren.
 * De taak operator of manager wordt random gegenereerd (gemiddeld 1 manager per 9 operators).
 * Het wachtwoord wordt gelijkgesteld aan de functie van de gebruiker om gemakkelijk te kunnen testen.
 * @throws DataInvoerException
 * @throws DataNietGevondenException
 */
public void maakGebruiker() throws DataInvoerException, DataNietGevondenException
{
	String functie = null;

	if (r.nextInt(10) < 9)
	{
		functie = "operator";
	}
	else
	{
		functie = "manager";
	};
	
	DBtools.updateTable("insert into gebruikers values ("+(DBtools.geefAantalRecords("gebruikers")+1)+",'"+g.generateName()+"','"+functie+"','"+functie+"')");	
}

/**
 * Deze method maakt het gespecifieerde aantal gebruikers aan.
 * @param aantal
 * @throws DataInvoerException
 * @throws DataNietGevondenException
 */
public void maakGebruikers(int aantal) throws DataInvoerException, DataNietGevondenException
{
	for (int i = 0; i < aantal; i++)
	{
		maakGebruiker();
	}
}

}
