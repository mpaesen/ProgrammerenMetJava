package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;



import business.Inschrijving;
import business.Reiziger;
import business.Verplaatsing;
import business.vervoermiddelen.VervoerMiddel;

public class Test {

	static ArrayList<VervoerMiddel> voertuigen = new ArrayList<VervoerMiddel>();
	static ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();
	static LinkedList<Inschrijving> inschrijvingen = new LinkedList<Inschrijving>();
	static LinkedList<Verplaatsing> verplaatsingen = new LinkedList<Verplaatsing>();
	
	public static void main(String[] args) {
		
		voertuigen = Randomizers.randomVoertuigen();
		reizigers = Randomizers.randomReizigers();
		inschrijvingen = Randomizers.randomInschrijvingen();
		
		
		Iterator<Reiziger> allerts = reizigers.iterator();		
		while(allerts.hasNext()){
			Iterator<Inschrijving> inschrijvingen = allerts.next().getInschrijvingen().iterator();	
			System.out.println(allerts.next().toString());
			while(inschrijvingen.hasNext()){
				Inschrijving inschrijving = inschrijvingen.next();
				System.out.print("\n\t"+inschrijving.toString());
			}
		}
	}
}
