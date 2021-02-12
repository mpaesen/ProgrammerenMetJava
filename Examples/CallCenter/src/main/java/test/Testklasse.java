package test;

import exceptions.DataInvoerException;
import exceptions.DataNietGevondenException;
import persistentie.test.MaakTestData;

public class Testklasse {

	/**
	 * @param args
	 * @throws DataNietGevondenException 
	 * @throws DataInvoerException 
	 */
	public static void main(String[] args) throws DataInvoerException, DataNietGevondenException 
	{
		MaakTestData mtd = new MaakTestData();
		mtd.maakGebruikers(20);
		mtd.maakKlanten(10);
	}

}
