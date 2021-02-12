/* Generated by Together */

package database.datastore;
/**
 * @persistent
 * @rdbPhysicalName HRADV1P 
 */
public class HRADV1P {
    public HRADV1P() {
    }

    /**
     * Unique card ID Adecco
     * @rdbPhysicalName CARD_IA_A1
     * @rdbNotNull
     * @rdbSize 7
     * @rdbDigits 0
     * @rdbLogicalType DECIMAL 
     */
    private double CARD_IA_A1;

    /**
     * Adecco Company Code
     * @rdbPhysicalName ADCYA1
     * @rdbNotNull
     * @rdbSize 3
     * @rdbDigits 0
     * @rdbLogicalType NUMERIC 
     */
    private double ADCYA1;

    /**
     * Temp Number
     * @rdbPhysicalName TEMPA1
     * @rdbNotNull
     * @rdbSize 7
     * @rdbDigits 0
     * @rdbLogicalType NUMERIC 
     */
    private double TEMPA1;

    /**
     * Status
     * @rdbPhysicalName STATUSA1
     * @rdbNotNull
     * @rdbSize 1
     * @rdbDigits 0
     * @rdbLogicalType CHAR 
     */
    private String STATUSA1;

    /**
     * Reject Reason Code
     * @rdbPhysicalName REJ_REASA1
     * @rdbNotNull
     * @rdbSize 3
     * @rdbDigits 0
     * @rdbLogicalType DECIMAL 
     */
    private double REJ_REASA1;

    /**
     * Request Type
     * @rdbPhysicalName RQSTTYPEA1
     * @rdbNotNull
     * @rdbSize 1
     * @rdbDigits 0
     * @rdbLogicalType CHAR 
     */
    private String RQSTTYPEA1;

    /**
     * Request date
     * @rdbPhysicalName DATE_REQA1
     * @rdbNotNull
     * @rdbSize 8
     * @rdbDigits 0
     * @rdbLogicalType DECIMAL 
     */
    private double DATE_REQA1;

    /**
     * Member name
     * @rdbPhysicalName MEMBERA1
     * @rdbNotNull
     * @rdbSize 10
     * @rdbDigits 0
     * @rdbLogicalType CHAR 
     */
    private String MEMBERA1;

    /**
     * Date From
     * @rdbPhysicalName DATE_FRMA1
     * @rdbNotNull
     * @rdbSize 8
     * @rdbDigits 0
     * @rdbLogicalType DECIMAL 
     */
    private double DATE_FRMA1;

    /**
     * Date To
     * @rdbPhysicalName DATE_TO_A1
     * @rdbNotNull
     * @rdbSize 8
     * @rdbDigits 0
     * @rdbLogicalType DECIMAL 
     */
    private double DATE_TO_A1;

    /**
     * Number of hours
     * @rdbPhysicalName HOURSA1
     * @rdbNotNull
     * @rdbSize 9
     * @rdbDigits 2
     * @rdbLogicalType DECIMAL 
     */
    private double HOURSA1;

    /**
     * Expected expiration date
     * @rdbPhysicalName EXEXDATEA1
     * @rdbNotNull
     * @rdbSize 8
     * @rdbDigits 0
     * @rdbLogicalType NUMERIC 
     */
    private double EXEXDATEA1;

    /**
     * Card number Corporatemade
     * @rdbPhysicalName CARDNMBRA1
     * @rdbNotNull
     * @rdbSize 7
     * @rdbDigits 0
     * @rdbLogicalType DECIMAL 
     */
    private double CARDNMBRA1;

    /**
     * Expiration date
     * @rdbPhysicalName DATE_EXPA1
     * @rdbNotNull
     * @rdbSize 8
     * @rdbDigits 0
     * @rdbLogicalType DECIMAL 
     */
    private double DATE_EXPA1;

    /**
     * Date confirmation
     * @rdbPhysicalName DATECONFA1
     * @rdbNotNull
     * @rdbSize 8
     * @rdbDigits 0
     * @rdbLogicalType DECIMAL 
     */
    private double DATECONFA1;

    /**
     * Creation Program for Record
     * @rdbPhysicalName CRPGA1
     * @rdbNotNull
     * @rdbSize 10
     * @rdbDigits 0
     * @rdbLogicalType CHAR 
     */
    private String CRPGA1;

    /**
     * Creation User for Record
     * @rdbPhysicalName CRUSA1
     * @rdbNotNull
     * @rdbSize 10
     * @rdbDigits 0
     * @rdbLogicalType CHAR 
     */
    private String CRUSA1;

    /**
     * Creation Date for Record
     * @rdbPhysicalName CRDTA1
     * @rdbNotNull
     * @rdbSize 8
     * @rdbDigits 0
     * @rdbLogicalType NUMERIC 
     */
    private double CRDTA1;

    /**
     * Creation Time for Record
     * @rdbPhysicalName CRTIA1
     * @rdbNotNull
     * @rdbSize 6
     * @rdbDigits 0
     * @rdbLogicalType NUMERIC 
     */
    private double CRTIA1;

    /**
     * Last Change Program Record
     * @rdbPhysicalName CHPGA1
     * @rdbNotNull
     * @rdbSize 10
     * @rdbDigits 0
     * @rdbLogicalType CHAR 
     */
    private String CHPGA1;

    /**
     * Last Change User for Record
     * @rdbPhysicalName CHUSA1
     * @rdbNotNull
     * @rdbSize 10
     * @rdbDigits 0
     * @rdbLogicalType CHAR 
     */
    private String CHUSA1;

    /**
     * Last Change Date for Record
     * @rdbPhysicalName CHDTA1
     * @rdbNotNull
     * @rdbSize 8
     * @rdbDigits 0
     * @rdbLogicalType NUMERIC 
     */
    private double CHDTA1;

    /**
     * Last Change Time for Record
     * @rdbPhysicalName CHTIA1
     * @rdbNotNull
     * @rdbSize 6
     * @rdbDigits 0
     * @rdbLogicalType NUMERIC 
     */
    private double CHTIA1;
	/**
	 * @return
	 */
	public double getADCYA1() {
		return ADCYA1;
	}

	/**
	 * @return
	 */
	public double getCARD_IA_A1() {
		return CARD_IA_A1;
	}

	/**
	 * @return
	 */
	public double getCARDNMBRA1() {
		return CARDNMBRA1;
	}

	/**
	 * @return
	 */
	public double getCHDTA1() {
		return CHDTA1;
	}

	/**
	 * @return
	 */
	public String getCHPGA1() {
		return CHPGA1;
	}

	/**
	 * @return
	 */
	public double getCHTIA1() {
		return CHTIA1;
	}

	/**
	 * @return
	 */
	public String getCHUSA1() {
		return CHUSA1;
	}

	/**
	 * @return
	 */
	public double getCRDTA1() {
		return CRDTA1;
	}

	/**
	 * @return
	 */
	public String getCRPGA1() {
		return CRPGA1;
	}

	/**
	 * @return
	 */
	public double getCRTIA1() {
		return CRTIA1;
	}

	/**
	 * @return
	 */
	public String getCRUSA1() {
		return CRUSA1;
	}

	/**
	 * @return
	 */
	public double getDATE_EXPA1() {
		return DATE_EXPA1;
	}

	/**
	 * @return
	 */
	public double getDATE_FRMA1() {
		return DATE_FRMA1;
	}

	/**
	 * @return
	 */
	public double getDATE_REQA1() {
		return DATE_REQA1;
	}

	/**
	 * @return
	 */
	public double getDATE_TO_A1() {
		return DATE_TO_A1;
	}

	/**
	 * @return
	 */
	public double getDATECONFA1() {
		return DATECONFA1;
	}

	/**
	 * @return
	 */
	public double getEXEXDATEA1() {
		return EXEXDATEA1;
	}

	/**
	 * @return
	 */
	public double getHOURSA1() {
		return HOURSA1;
	}

	/**
	 * @return
	 */
	public String getMEMBERA1() {
		return MEMBERA1;
	}

	/**
	 * @return
	 */
	public double getREJ_REASA1() {
		return REJ_REASA1;
	}

	/**
	 * @return
	 */
	public String getRQSTTYPEA1() {
		return RQSTTYPEA1;
	}

	/**
	 * @return
	 */
	public String getSTATUSA1() {
		return STATUSA1;
	}

	/**
	 * @return
	 */
	public double getTEMPA1() {
		return TEMPA1;
	}

	/**
	 * @param d
	 */
	public void setADCYA1(double d) {
		ADCYA1 = d;
	}

	/**
	 * @param d
	 */
	public void setCARD_IA_A1(double d) {
		CARD_IA_A1 = d;
	}

	/**
	 * @param d
	 */
	public void setCARDNMBRA1(double d) {
		CARDNMBRA1 = d;
	}

	/**
	 * @param d
	 */
	public void setCHDTA1(double d) {
		CHDTA1 = d;
	}

	/**
	 * @param string
	 */
	public void setCHPGA1(String string) {
		CHPGA1 = string;
	}

	/**
	 * @param d
	 */
	public void setCHTIA1(double d) {
		CHTIA1 = d;
	}

	/**
	 * @param string
	 */
	public void setCHUSA1(String string) {
		CHUSA1 = string;
	}

	/**
	 * @param d
	 */
	public void setCRDTA1(double d) {
		CRDTA1 = d;
	}

	/**
	 * @param string
	 */
	public void setCRPGA1(String string) {
		CRPGA1 = string;
	}

	/**
	 * @param d
	 */
	public void setCRTIA1(double d) {
		CRTIA1 = d;
	}

	/**
	 * @param string
	 */
	public void setCRUSA1(String string) {
		CRUSA1 = string;
	}

	/**
	 * @param d
	 */
	public void setDATE_EXPA1(double d) {
		DATE_EXPA1 = d;
	}

	/**
	 * @param d
	 */
	public void setDATE_FRMA1(double d) {
		DATE_FRMA1 = d;
	}

	/**
	 * @param d
	 */
	public void setDATE_REQA1(double d) {
		DATE_REQA1 = d;
	}

	/**
	 * @param d
	 */
	public void setDATE_TO_A1(double d) {
		DATE_TO_A1 = d;
	}

	/**
	 * @param d
	 */
	public void setDATECONFA1(double d) {
		DATECONFA1 = d;
	}

	/**
	 * @param d
	 */
	public void setEXEXDATEA1(double d) {
		EXEXDATEA1 = d;
	}

	/**
	 * @param d
	 */
	public void setHOURSA1(double d) {
		HOURSA1 = d;
	}

	/**
	 * @param string
	 */
	public void setMEMBERA1(String string) {
		MEMBERA1 = string;
	}

	/**
	 * @param d
	 */
	public void setREJ_REASA1(double d) {
		REJ_REASA1 = d;
	}

	/**
	 * @param string
	 */
	public void setRQSTTYPEA1(String string) {
		RQSTTYPEA1 = string;
	}

	/**
	 * @param string
	 */
	public void setSTATUSA1(String string) {
		STATUSA1 = string;
	}

	/**
	 * @param d
	 */
	public void setTEMPA1(double d) {
		TEMPA1 = d;
	}

}
