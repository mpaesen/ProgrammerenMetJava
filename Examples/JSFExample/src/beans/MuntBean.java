/** 
 *  Exercise : 		Opdracht_3 : Ontwerpen met java
 *  FileName :   	Adres.java
 *  @author Pascal Sempels 
 *  @version Revision : 1.0  date : 06/02/2010
 *  
 *  MuntBean :Classe die wordt gebruik om gegevens te versturen naar Munt.jsp 
 */
package beans;

import Persistentie.DAOConfigurationException;
import Persistentie.MuntPersistentController;

import javax.faces.model.SelectItem;
import java.util.ArrayList;

//Members
public class MuntBean {
private double bedrag;
private String wisselkoersVan;
private String wisselkoersNaar;
private double result;
private String functie;
private ArrayList<Double> koersen=null;
private ArrayList<SelectItem> muntBenamingen=null;
private MuntPersistentController muntcntrl=null;
private boolean aangepast = true;
//Constructor

/**
 * Default Constructor 
 */
public MuntBean() {
	setAangepast(true);
	try {
		muntcntrl = new MuntPersistentController();
	} catch (DAOConfigurationException e) {
			e.printStackTrace();
	} catch (Exception e) {
			e.printStackTrace();
	}
	this.muntBenamingen = new ArrayList<SelectItem>();
	this.koersen = muntcntrl.getWisselkoersen();
	int teller=1;
	for(String item : muntcntrl.getMuntbenamingen()){
		this.muntBenamingen.add(new SelectItem(teller,item));
		teller++;
	}
	
}
/**
 * @return the bedrag
 */

//Getters en setters

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
 * @return the wisselkoersVan
 */
public String getWisselkoersVan() {
	return wisselkoersVan;
}
/**
 * @param wisselkoersVan the wisselkoersVan to set
 */
public void setWisselkoersVan(String wisselkoersVan) {
	this.wisselkoersVan = wisselkoersVan;
}
/**
 * @return the wisselkoersNaar
 */
public String getWisselkoersNaar() {
	return wisselkoersNaar;
}
/**
 * @param wisselkoersNaar the wisselkoersNaar to set
 */
public void setWisselkoersNaar(String wisselkoersNaar) {
	this.wisselkoersNaar = wisselkoersNaar;
}
/**
 * @return the result
 */
public double getResult() {
	return result;
}
/**
 * @param result the result to set
 */
public void setResult(double result) {
	this.result = result;
}
/**
 * @return the functie
 */
public String getFunctie() {
	return functie;
}
/**
 * @param functie the functie to set
 */
public void setFunctie(String functie) {
	this.functie = functie;
}
public void setKoersen(ArrayList<Double> koersen) {
	this.koersen = koersen;
}
public ArrayList<Double> getKoersen() {
	return koersen;
}
public void setMuntBenamingen() {
	try {
		muntcntrl = new MuntPersistentController();
	} catch (DAOConfigurationException e) {
			e.printStackTrace();
	} catch (Exception e) {
			e.printStackTrace();
	}
	this.muntBenamingen = new ArrayList<SelectItem>();
	int teller = 1;
	for(String item : muntcntrl.getMuntbenamingen()){
		this.muntBenamingen.add(new SelectItem(teller,item));
		teller++;
	}
}
public ArrayList<SelectItem> getMuntBenamingen() {
		return this.muntBenamingen;
}

//methods
/**
 * Methode om het eindresultaat te berkenen
 */
public String berekenBedrag(){
	setAangepast(false);
	
	this.result = bedrag * this.koersen.get(Integer.parseInt(getWisselkoersNaar())-1)/ this.koersen.get(Integer.parseInt(getWisselkoersVan())-1);
	return String.format("%.5f", this.result);
}
public void setAangepast(boolean aangepast) {
	this.aangepast = aangepast;
}
public boolean isAangepast() {
	return aangepast;
}



}
