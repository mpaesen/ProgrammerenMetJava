/*
 * Created on Oct 20, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package model;

import java.math.BigDecimal;

/**
 * @author bempn
 * 
 */
public class HouseHold {
	private static int actualHousehold = 0;

	private String identification;

	private BigDecimal yearlyInCome;

	private int numberOfPersons;

	/**
	 * @param identification
	 * @param yearlyInCome
	 * @param numberOfPersons
	 */
	public HouseHold(String identification, BigDecimal yearlyInCome, int numberOfPersons) {		
		setID(identification);
		setYearlyInCome(yearlyInCome);
		setNumberOfPersons(numberOfPersons);
		actualHousehold++;
	}

	/**
	 * @return Returns the iD.
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * @return Returns the numberOfPersons.
	 */
	public int getNumberOfPersons() {
		return numberOfPersons;
	}

	/**
	 * @return Returns the yearlyInCome.
	 */
	public BigDecimal getYearlyInCome() {
		return yearlyInCome;
	}

	/**
	 * @param id
	 *            The iD to set.
	 */
	private void setID(String id) {
		identification = id;
	}

	/**
	 * @param numberOfPersons
	 *            The numberOfPersons to set.
	 */
	private void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	/**
	 * @param yearlyInCome
	 *            The yearlyInCome to set.
	 */
	private void setYearlyInCome(BigDecimal yearlyInCome) {
		this.yearlyInCome = yearlyInCome;
	}

	/**
	 * @return Returns the actualHousehold.
	 */
	public static int getActualHousehold() {
		return actualHousehold;
	}
	
	public String toString(){
		return "\nId "+this.getIdentification()+" with a Yearly Income of ?"+this.getYearlyInCome().toString()+" and with "+ this.getNumberOfPersons()+ " family members";
	}
}