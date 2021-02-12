package model.vaartuigen;

import model.deuren.Deur;
import model.vensters.Venster;
import utilities.Category;

import java.math.BigDecimal;

public class Boot extends Vaartuig {

	public Boot(Category cat, BigDecimal waarde){
		super(cat, waarde);
		setDeuren(new Deur[1+(int)(Math.random() * 50.0)], "Kajuit");
		setVensters(new Venster[1+(int)(Math.random() * 50.0)], "Getinte");
	}
	
           
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("Deze Boot is "+getKleur()+"\n\t en heeft als deuren"+getDeuren()+" \n\t met als vensters"+getVensters());
		return buffer.toString();
	}
	
}
