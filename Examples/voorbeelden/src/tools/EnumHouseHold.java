/*
 * Created on Oct 20, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package tools;

import java.math.BigDecimal;
public enum EnumHouseHold {

	HOUSEHOLD1("1041", new BigDecimal("12180"),	4),
	HOUSEHOLD2("1062", new BigDecimal("13240"),	3),
	HOUSEHOLD3("1327", new BigDecimal("19800"),	2),
	HOUSEHOLD4("1483", new BigDecimal("22458"),	8),
	HOUSEHOLD5("1900", new BigDecimal("17000"),	2),
	HOUSEHOLD6("2112", new BigDecimal("18125"),	7),
	HOUSEHOLD7("2345", new BigDecimal("15623"),	2),
	HOUSEHOLD8("3210", new BigDecimal("3200"),	6),
	HOUSEHOLD9("3600", new BigDecimal("6500"),	5),
	HOUSEHOLD10("3601", new BigDecimal("11970"),	2),
	HOUSEHOLD11("4725", new BigDecimal("8900"),	3),
	HOUSEHOLD12("6217", new BigDecimal("10000"),	2),
	HOUSEHOLD13("9280", new BigDecimal("6200"),	1);
	
			

	private final String identification;
	private final BigDecimal yearlyInCome;
	private final int numberOfPersons;

	 EnumHouseHold(String ID, BigDecimal yearlyInCome, int numberOfPersons){
		this.identification = ID;
		this.yearlyInCome = yearlyInCome;
		this.numberOfPersons = numberOfPersons;
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
}