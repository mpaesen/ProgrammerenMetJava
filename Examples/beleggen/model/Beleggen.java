// This program is used to calculate some amounts related to
// your investments


package model;

import utilities.Input;
/** De class beleggen heeft tot doel op een flexibele manier 
de gebruiker een vastrentende belegging na te rekenen */
public class Beleggen
{

/** berekent de Interest op basis van het
beginkapitaal en het verworven EindBedrag */
public static void berekenInterest(Amount amount)
	{amount.setKapitaal(Input.leesBedrag("kapitaal"));
	 amount.setEindBedrag(Input.leesBedrag("EindBedrag"));
	 amount.setJaren((int)Input.leesBedrag("het aantal belegde jaren"));
	 System.out.println(" Jaren, "+amount.getJaren());
   	System.out.println(" Eindbedrag, "+amount.getEindBedrag());
   	System.out.println(" Kapitaal, "+amount.getKapitaal());
	 amount.berekenInterest();
	 amount.printInterest("Interest");
	}


/** berekent het kapitaal op basis van 
het verworven EindBedrag en de gekende Interest */
public static void berekenKapitaal(Amount amount)
	{amount.setInterest(Input.leesBedrag("Interest"));
	 amount.setEindBedrag(Input.leesBedrag("EindBedrag"));
	 amount.setJaren((int)Input.leesBedrag("het aantal belegde jaren"));
	 amount.berekenKapitaal();
	 amount.printKapitaal("kapitaal");
	}


/** berekent het EindBedrag op basis
van het beginkapitaal en de Interest */
public static void berekenEindBedrag(Amount amount)
	{amount.setKapitaal(Input.leesBedrag("kapitaal"));
	 amount.setInterest(Input.leesBedrag("Interest"));
	 amount.setJaren((int)Input.leesBedrag("het aantal belegde jaren"));
	 amount.berekenEindBedrag();
	 amount.printEindBedrag("EindBedrag");
	}
}