/*
 * Created on Oct 20, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package ui;

import model.HouseHold;
import model.Township;
import tools.EnumHouseHold;

import javax.swing.*;
import java.math.BigDecimal;

import static tools.Utilities.*;

/**
 * @author bempn
 * 
 * Preferences - Java - Code Style - Code Templates
 */
public class TownshipJUnit{
	private static final String ID = "Identification number : ";
	private static final String INCOME = "Yearly income : ";
	private static final String NUMBER_OF_PERSONS = "Number of persons : ";


	/**
	 * @return
	 */
	public HouseHold newHouseHold(){
		String id = JOptionPane.showInputDialog(null,ID);
		BigDecimal yearlyIncome = new BigDecimal(getDoubleNumber(INCOME));
		int numberOfPersons = Integer.parseInt(getIntegerNumber(NUMBER_OF_PERSONS));
		return new HouseHold(id, yearlyIncome, numberOfPersons); 
	}
	/**
	 * @param args
	 */
	public void testTownship(String[]args) {
		Township township = null;
		if ((args.length == 0) || (!isDigit(args[0]))) {
			township = new Township(13);
			for(EnumHouseHold houseHold : EnumHouseHold.values()){
				township.newHouseHold(new HouseHold(houseHold.getIdentification(), houseHold.getYearlyInCome(), houseHold.getNumberOfPersons()));
			}
		} else {
			township = new Township(Integer.parseInt(args[0]));
			for(int i = 0; i< township.getHOUSEHOLDS(); i++){ 
				township.newHouseHold(newHouseHold()); 
			}
		}
				
		this.testAverageIncome(township);
		this.testNumberOfHouseHolds(township);
		this.testMoreThanAverage(township);
		this.testPercentagePoorFamilies(township);
	}

	/**
	 * @param township
	 */
	public void testAverageIncome(Township township) {
		JOptionPane.showMessageDialog(null,"�"+township.averageIncome(),"Average Income",1);
	}

	/**
	 * @param township
	 */
	public void testNumberOfHouseHolds(Township township) {
		JOptionPane.showMessageDialog(null,township.numberOfHouseHolds(),"Number of House Holds",1);
	}

	/**
	 * @param township
	 */
	public void testMoreThanAverage(Township township) {
		StringBuffer buffer = new StringBuffer();
		for(HouseHold houseHold : township.moreThanAverage()){
			buffer.append(houseHold.toString());
		}
		JOptionPane.showMessageDialog(null,buffer.toString(),"More than Average",1);
	}

	
	/**
	 * @param township
	 */
	public void testPercentagePoorFamilies(Township township) {			
		JOptionPane.showMessageDialog(null,township.percentagePoorFamilies()+"%","% Poor families",1);
	}

}