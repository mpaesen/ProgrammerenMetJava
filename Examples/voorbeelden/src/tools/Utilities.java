package tools;

import javax.swing.*;

public class Utilities {
	private static final String READ_NUMBER ="Please give a positive number between 1 and 30!";
	private static final String NOT_CORRECT ="No correct number!\nPlease try again!";	
	private static final int UPPER = 30;
	private static final int LOWER = 1;

	/**
	 * @param str
	 * @return
	 */
	public static boolean isDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(0)))
				return false;
		}
		return true;
	}

	/**
	 * @param number
	 * @return
	 */
	public static boolean isCorrectInteger(String number){
		
			try {
				int integernumber = Integer.parseInt(number);
				if((integernumber > UPPER) || (integernumber < LOWER)){
					JOptionPane.showMessageDialog(null,READ_NUMBER);
					return false;
				}
				return true;		
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,NOT_CORRECT);
				return false;
			}
		}
	
	/**
	 * @param number
	 * @return
	 */
	public static boolean isCorrectDouble(String number){
		
			try {
				Double.parseDouble(number);
				return true;		
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,NOT_CORRECT);
				return false;
			}
		}
	/**
	 * @return
	 */
	public static String getIntegerNumber(String title){
		String number = null;
		do{
			number = JOptionPane.showInputDialog(null,title);
		}while(!isCorrectInteger(number));
		return number;
	}
	
	
	/**
	 * @return
	 */
	public static String getDoubleNumber(String title){
		String number = null;
		do{
			number = JOptionPane.showInputDialog(null,title);
		}while(!isCorrectDouble(number));
		return number;
	}



}
