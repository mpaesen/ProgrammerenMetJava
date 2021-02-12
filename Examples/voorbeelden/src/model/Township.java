/*
 * Created on Oct 20, 2005
 *
 *
 */
package model;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author bempn
 * 
 *  
 */
public class Township {
	private final int HOUSEHOLDS;
	private static int count;
	private static final double UPPER = 6500.0;
	private static final double LOWER = 750.0;
	private BigDecimal avg = null;
	private HouseHold[] households = null;

	/**
	 *  
	 */
	public Township(int families) {
		HOUSEHOLDS = families;
		households = new HouseHold[HOUSEHOLDS];
	}

	/**
	 * @return
	 */
	public BigDecimal averageIncome() {
		if (avg == null) {
			double total = 0.0;
			double average = 0.0;
			for (int i = 0; i < households.length; i++) {
				total += households[i].getYearlyInCome().doubleValue();
			}
			average = this.numberOfHouseHolds() != 0 ? total / this.numberOfHouseHolds(): 0.0;
			new BigDecimal(average, new MathContext(7));
		}
		return avg;
	}

	/**
	 * @return
	 */
	public int numberOfHouseHolds() {
		int count = 0;
		for (int i = 0; i < households.length; i++) {
			if (households[i] != null)
				count++;
		}
		return count;
	}

	/**
	 * @return
	 */
	public HouseHold[] moreThanAverage() {
		HouseHold[] more = new HouseHold[HOUSEHOLDS];
		int count = 0;
		for (int i = 0; i < households.length; i++) {
			
			if (households[i] == null)
				continue;
			if(households[i].getYearlyInCome().compareTo(this.averageIncome())>0){
				more[count++]=households[i];
			}
		}
		HouseHold[] allAverages = new HouseHold[count]; 
		System.arraycopy(more,0,allAverages,0,allAverages.length);
		return allAverages;
	}

	/**
	 * @return
	 */
	public BigDecimal percentagePoorFamilies() {
		double percentage = 0.0;
		int totalPoor = 0;
		for (int i = 0; i < households.length; i++) {
			if (households[i] == null) {
				continue;
			}
			if (poorFamily(households[i])) {
				totalPoor++;
			}
		}
		percentage = numberOfHouseHolds() > 0 ? 100.0 * (double) totalPoor / numberOfHouseHolds() : 0.0;

		return new BigDecimal(percentage, new MathContext(4));
	}

	/**
	 * armoedegrens = 6500.0 ? + 750.0 ?* (m ? 2) waarbij m het aantal leden in
	 * een gezin is.
	 * 
	 * @param family
	 * @return
	 */
	private boolean poorFamily(HouseHold family) {
		double poor = UPPER	+ (LOWER * (family.getNumberOfPersons() - 2));
		//System.out.printf("\nIncome: %10f, poor if < %10f",family.getYearlyInCome().doubleValue(),poor);
		return family.getYearlyInCome().compareTo(
				new BigDecimal(poor)) < 0;
	}	
	/**
	 * @param family
	 */
	public void newHouseHold(HouseHold family){
		households[count++] = family;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i<households.length; i++){
			buffer.append(households[i].toString());
			buffer.append("\n");
		}
		return buffer.toString();
	}

	/**
	 * @return Returns the households.
	 */
	public HouseHold[] getHouseholds() {
		return households;
	}

	/**
	 * @param households The households to set.
	 */
	public void setHouseholds(HouseHold[] households) {
		this.households = households;
	}

	/**
	 * @return Returns the hOUSEHOLDS.
	 */
	public int getHOUSEHOLDS() {
		return HOUSEHOLDS;
	}
}