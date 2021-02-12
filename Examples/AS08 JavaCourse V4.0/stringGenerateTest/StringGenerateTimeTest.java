/*
 * Created on Oct 11, 2004
 *
 * Changes made on Oct 08, 2006
 */
package model;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * @author bempn
 *
 * @version 1.1 changes made by Snellinx Guy, decomposing the main method.
 * 
 */
public class StringGenerateTimeTest {
	
	public static final int LOOPS = 10000;
	
	private String askInput(){
		return JOptionPane.showInputDialog(
		"Wenst u een String test of een StringBuffer test? (S/B)");
	}
	
	private void stringBufferConcatenate(String word){
		StringBuffer buffer = new StringBuffer("Test ");
		for (int i = 0; i < LOOPS; i++) {
			buffer.append(i);
		}
	}
	
	private void stringConcatenate(String word){
		for (int i = 0; i < LOOPS; i++) {
			word += i;
		}
	}
	
	private String composeTimeToExecute(long minutes, long seconds, long milliseconds, char chose){
		StringBuffer sb = new StringBuffer();
		sb.append(minutes);
		sb.append(" minutes, ");
		sb.append(seconds);
		sb.append(" seconds and ");
		sb.append(milliseconds);
		sb.append(" miliseconds needed for ");
		sb.append(LOOPS);
		sb.append(chose=='B'?" StringBuffers":" Strings");
		return sb.toString();
		
		
	}
	
	public static void main(String[] args) {
		StringGenerateTimeTest stringVsStringBuffer = new StringGenerateTimeTest();

		String input = stringVsStringBuffer.askInput();
			
		long t1 = System.currentTimeMillis();
		char choise = Character.toUpperCase(input.charAt(0));
		if (choise  == 'B') {
			stringVsStringBuffer.stringBufferConcatenate("Test ");
			
		} else {
			stringVsStringBuffer.stringConcatenate("Test ");
		}

		long t2 = System.currentTimeMillis();
		long elaps = t2 - t1;
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(elaps);
		
		long minutes, seconds, milliseconds;
		minutes = calendar.get(Calendar.MINUTE);
		seconds = calendar.get(Calendar.SECOND);
		milliseconds = calendar.get(Calendar.MILLISECOND);
		
		JOptionPane.showMessageDialog(
			null,
			stringVsStringBuffer.composeTimeToExecute(minutes, seconds, milliseconds,choise),
			"Time elaps",
			JOptionPane.WARNING_MESSAGE);
	}
}
