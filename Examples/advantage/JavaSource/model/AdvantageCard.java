/*
 * Created on Feb 17, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AdvantageCard {
	private String tempNo;
	private String tempName;
	private String cardExpiration;
	private String cardStatus;

	/**
	 * 
	 */
	public AdvantageCard() {
		super();
	}
	
	
	/**
	 * 
	 */
	public AdvantageCard(
		int tempNo,
		String tempName,
		String cardExpiration,
		String cardStatus) {
		super();
		setTempNo(tempNo);
		setTempName(tempName);
		setCardExpiration(getExpirationDateFormatted(cardExpiration));
		//setCardExpiration(cardExpiration);
		setCardStatus(convertCardStatus(cardStatus));
	}
	/**
	 * @return
	 */
	private String getExpirationDateFormatted(String cardExpiration) {
		int day;
		int month;
		int year;
		SimpleDateFormat dateFormat;

		String date = "0";
		dateFormat = new SimpleDateFormat("dd MMM yyy");
		if (cardExpiration.equals("0")) {
			return date;
		}
		year = Integer.parseInt(cardExpiration.substring(2, 4));
		month = (Integer.parseInt(cardExpiration.substring(4, 6)) -1);  //0= januari, ...
		day = Integer.parseInt(cardExpiration.substring(6, 8));
		date =
			dateFormat.format(
				(new GregorianCalendar(1900 +(year - 1900), month, day).getTime())); //year since 1900
		return date;
	}

	/**
	 * @return
	 */
	private String convertCardStatus(String cardStatus) {
		if (cardStatus.equals("C"))
			return "Received";
		return "To Receive";
	}

	/**
	* @return
	*/
	public String getCardExpiration() {
		return cardExpiration;
	}

	/**
	 * @return
	 */
	public String getCardStatus() {
		return cardStatus;
	}

	/**
	 * @return
	 */
	public String getTempName() {
		return tempName;
	}

	/**
	 * @return
	 */
	public String getTempNo() {
		return tempNo;
	}

	/**
	 * @param string
	 */
	public void setCardExpiration(String string) {
		cardExpiration = string;
	}

	/**
	 * @param string
	 */
	public void setCardStatus(String string) {
		cardStatus = string;
	}

	/**
	 * @param string
	 */
	public void setTempName(String string) {
		
		tempName = string;
	}

	/**
	 * @param d
	 */
	public void setTempNo(int d) {
		DecimalFormat elevenDigits = new DecimalFormat("00 ");
		tempNo = elevenDigits.format(d);				
	}

}
