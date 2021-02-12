package ui;

import model.NumberAsString;

import javax.swing.*;

public class NumberAsStringTest {
	private static final String NIET_CORRECT ="Dit is geen correct getal!\nProbeer opnieuw!";
	private static final String LEES_GETAL ="Lees een getal in tussen 0 en 999\ngeef een negatief getal om te stoppen!";
	private static final String FOUT = "Er heeft zich een fout\n voorgedaan met het getal ";
	private static final String ONTLEED =" in ontleedGetal()";
	private static final String EINDE ="Einde van de applicatie!";
	/**
	 * @param getal
	 * @return correct (true/false)
	 */
	public static boolean isCorrect(String getal){
	
		try {
			int integerGetal = Integer.parseInt(getal);
			if(integerGetal >= 1000){
				JOptionPane.showMessageDialog(null,NIET_CORRECT);
				return false;
			}
			return true;		
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,NIET_CORRECT);
			return false;
		}
	}
	/**
	 * @return getal
	 */
	public static String getNumber(){
		String getal = null;
		do{
			getal = JOptionPane.showInputDialog(null,LEES_GETAL);
		}while(!isCorrect(getal));
		return getal;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NumberAsString nas = new NumberAsString();
		
		nas.setOorspronkelijkGetal(getNumber());
		while(nas.getGetal()>=0){
			if(!nas.ontleedGetal()){
				JOptionPane.showMessageDialog(null,
						FOUT
								+ nas.getGetal() + ONTLEED);
			}
			JOptionPane.showMessageDialog(null,nas.toString());
			nas.setOorspronkelijkGetal(getNumber());
		}
		
		JOptionPane.showMessageDialog(null,EINDE);
		System.exit(0);
	}

}
