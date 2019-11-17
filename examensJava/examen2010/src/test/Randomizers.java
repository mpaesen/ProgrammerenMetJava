package test;

import java.util.ArrayList;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import test.enums.Berichten;
import test.enums.Namen;
import test.enums.Steden;
import test.enums.Voertuigen;
import test.enums.Voornamen;

import factories.BerichtFactory;
import factories.InformatieFactory;
import factories.VervoerMiddelFactory;


import business.Verplaatsing;
import business.Inschrijving;
import business.Reiziger;
import business.Datum;

import business.berichten.Bericht;
import business.vervoermiddelen.VervoerMiddel;

public final class Randomizers {
	private static Random random = new Random();
	private final static int AANTAL_REIZIGERS = 20;
	private final static int AANTAL_VOERTUIGEN = 20;
	private final static int AANTAL_INSCHRIJVINGEN = 3;
	private final static int AANTAL_BERICHTEN = 3;
	private final static int MAX_UREN = 5;
	private final static int MAX_MINUTEN = 59;
	
	
	public static ArrayList<VervoerMiddel>  randomVoertuigen(){
		ArrayList<VervoerMiddel> voertuigen = new ArrayList<VervoerMiddel>();
		for(int i=0; i<AANTAL_VOERTUIGEN; i++){
			voertuigen.add(randomVoertuig());
		}
		return voertuigen;
	}
	public static ArrayList<Reiziger>  randomReizigers(){
		ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();
		LinkedList<Inschrijving> inschrijvingen;
		Reiziger reiziger;
		for(int i=0; i<AANTAL_REIZIGERS; i++){
			reiziger = randomReiziger();
			inschrijvingen = randomInschrijvingen();
			reiziger.setInschrijvingen(inschrijvingen);
			reizigers.add(reiziger);
		}
		return reizigers;
	}
	public static LinkedList<Inschrijving>  randomInschrijvingen(){
		LinkedList<Inschrijving> inschrijvingen = new LinkedList<Inschrijving>();	
		for(int i=0; i<AANTAL_INSCHRIJVINGEN; i++){	
			inschrijvingen.add(randomInschrijving(i+1));
		}
		return inschrijvingen;
	}
	
	
	public static ArrayList<Bericht> randomBerichten(){
		ArrayList<Bericht> berichten = new ArrayList<Bericht>();
		for(int i = 0; i<AANTAL_BERICHTEN;i++){
			berichten.add(randomBericht());
		}
		return berichten;
	}
	
	public static Bericht randomBericht(){
		BerichtFactory factory = new BerichtFactory();
		return factory.createBericht(1+random.nextInt(AANTAL_BERICHTEN), Berichten.values()[random.nextInt(Berichten.values().length)].name());		
	}
	
	public static Steden randomStad(){
		return Steden.values()[random.nextInt(Steden.values().length)];
	}
	
	public static Reiziger randomReiziger(){
		Reiziger reiziger  = new Reiziger();
		reiziger.setNaam(Namen.values()[random.nextInt(Namen.values().length)].name());		
		reiziger.setVoorNaam(Voornamen.values()[random.nextInt(Voornamen.values().length)].name());
		reiziger.setBerichtVoorkeurMedium(Berichten.values()[random.nextInt(Berichten.values().length)].name());
		return reiziger;
	}
	
	public static VervoerMiddel randomVoertuig(){
		VervoerMiddelFactory factory = new VervoerMiddelFactory();
		return factory.createVervoermiddel(1+random.nextInt(Voertuigen.values().length));
	}
	
	public static Verplaatsing randomVerplaatsing(){
		Datum van = new Datum();
		Datum tot = new Datum();
		tot.add(GregorianCalendar.HOUR, random.nextInt(MAX_UREN));
		tot.add(GregorianCalendar.MINUTE, random.nextInt(MAX_MINUTEN));
		
		Verplaatsing verplaatsing = new Verplaatsing(randomStad(), randomStad(), randomVoertuig(), van, tot);
		return verplaatsing;
	}
	
	public static Inschrijving randomInschrijving(int i){
		InformatieFactory factory = new InformatieFactory();	
		Verplaatsing verplaatsing = randomVerplaatsing();
		return new Inschrijving(new Datum(), factory.createInformatie(i,  verplaatsing, randomBerichten()));
	}
}
