/** 
 *  Exercise : 		Opdracht3 : Ontwerpen met java
 *  FileName :   	Adres.java
 *  @author Pascal Sempels 
 *  @version Revision : 1.0  date : 06/02/2010
 *  
 *  MuntPersistenController.java :KontrollerClasse die wordt gebruikt om gegevens gaan op te halen uit een txt-bestand 
 */
package Persistentie;

import java.io.FileNotFoundException;
import java.util.ArrayList;



public class MuntPersistentController {
	 //Members
	private ArrayList<Double> wisselkoersen = null;
	private ArrayList<String> muntbenamingen= null;
	private String muntVan="";
	private String muntNaar="";
	private double koersVan =0.0;
	private double koersNaar =0.0;
	private double bedrag =0.0;
	
		//Getters en Setters
	/**
	 * @return the bedrag
	 */
	public double getBedrag() {
		return bedrag;
	}
	/**
	 * @param bedrag the bedrag to set
	 */
	public void setBedrag(double bedrag) {
		this.bedrag = bedrag;
	}
	/**
	 * @return the wisselkoersen
	 */
	public ArrayList<Double> getWisselkoersen() {
			return wisselkoersen;
	}
	/**
	 * @param wisselkoersen the wisselkoersen to set
	 */
	public void setWisselkoersen(ArrayList<Double> wisselkoersen) {
		
		this.wisselkoersen = wisselkoersen;
	}
	/**
	 * @return the muntbenamingen
	 */
	public ArrayList<String> getMuntbenamingen() {
		return muntbenamingen;
	}
	/**
	 * @param muntbenamingen the muntbenamingen to set
	 */
	public void setMuntbenamingen(ArrayList<String> muntbenamingen) {
		this.muntbenamingen = muntbenamingen;
	}
	public void setKoersVan(String koersBenaming){
		int index = 0;
		int gevondenIndex=-1;

		for (String str : this.muntbenamingen) {
			if(str.equals(koersBenaming)){ 
				gevondenIndex = index;
				
			}
			index++;
		}
		if (gevondenIndex >= 0){
			this.koersVan= this.wisselkoersen.get(gevondenIndex);
		}
	}
	
	public double getKoersVan() {
		return koersVan;
	}
	public void setKoersNaar(String koersBenaming) {
		int index = 0;
		int gevondenIndex=-1;

		for (String str : this.muntbenamingen) {
			if(str.equals(koersBenaming)){ 
				gevondenIndex = index;
				
			}
			index++;
		}
		if (gevondenIndex >= 0){
			this.koersNaar= this.wisselkoersen.get(gevondenIndex);
		}
	}
	public double getKoersNaar() {
		return koersNaar;
	}
	public double getResultaat() {
		double result =0.0; 
		try {
		result = this.bedrag *this.koersNaar/this.koersVan;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//Constructors
	/**
	 * Default Constructor
	 */
	public MuntPersistentController() throws DAOConfigurationException,Exception{ 
		this.muntbenamingen = new ArrayList<String>();
		this.wisselkoersen= new ArrayList<Double>();
		try {
			loadGegevens();
		}catch (DAOConfigurationException daoe){
			 throw new DAOConfigurationException( daoe);
		}catch (Exception e) {
			new Exception(e);
		}
	
	}
	
	//Method's
	/**
	 * Initiatie metode om de gegevens op te halen
	 */
	public void loadGegevens() throws NumberFormatException, FileNotFoundException ,DAOConfigurationException{
	
		
			PropertiesLoader propKoers = null;
			PropertiesLoader propCode = null;
			PropertiesLoader propNaam = null;
			PropertiesLoader propNr =null; 
			ArrayList<String> codes = new ArrayList<String>();
				
				try {
					propNr = new PropertiesLoader("Wisselkoers");
					propKoers = new PropertiesLoader("Wisselkoers.euro2");
					propCode = new PropertiesLoader("Wisselkoers.code");
					propNaam = new PropertiesLoader("Wisselkoers.naam");
				} catch (DAOConfigurationException e) {
					throw new DAOConfigurationException(e);
				} catch (FileNotFoundException e) {
					throw new FileNotFoundException();
				}
			

			int aantal;
			aantal = Integer.parseInt(propNr.getPropertie("aantal"));
			for ( int teller = 0 ; teller < aantal; teller ++){
				codes.add(propCode.getPropertie(""+teller));
			}
			for (String str : codes) {
				this.muntbenamingen.add(propNaam.getPropertie(str));
			}	
			for (String str : codes) {
				this.wisselkoersen.add(Double.parseDouble(propKoers.getPropertie(str)));
			}
}
	public void setMuntVan(String muntVan) {
		this.muntVan = muntVan;
	}
	public String getMuntVan() {
		return muntVan;
	}
	public void setMuntNaar(String muntNaar) {
		this.muntNaar = muntNaar;
	}
	public String getMuntNaar() {
		return muntNaar;
	}	




	
	
	
	

}
