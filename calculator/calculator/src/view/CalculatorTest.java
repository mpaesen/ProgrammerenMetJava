
package view;

import javax.swing.JOptionPane;

import business.Calculator;

/**
 * @author Mathy Paesen
 * @version 1.1 refactoring
 * @category Programmeren met java
 * 
 */
public class CalculatorTest {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		final String FIRST = "Give first Value: ";
		final String SECOND = "Give second Value: ";
		final String OPERATION = "Give the operation (+, -, *, /, ^): ";
		final String RESULT = "The result of: \n";

		double result;
		double first, second;
		char operator;

		String message = new String(RESULT);
		String input = dialog(FIRST);

		// conversion of input into "first" value
		first = Double.parseDouble(input);
		input = dialog(SECOND);
		// conversion of input into "second" value
		second = Double.parseDouble(input);
		input = dialog(OPERATION);
		// substring of input into "operator"
		operator = input.charAt(0);
		//instantiation of business class
		final Calculator calculator = new Calculator();
		result = calculator.result(first, second, operator);
		// prepare message
		message = getResult(message, first, second, operator);
		message = String.format("%s %5.2f", message, result);
		// show message
		JOptionPane.showMessageDialog(null, message);
	}

	private static String dialog(String text) {
		return JOptionPane.showInputDialog(text);
	}

	private static String getResult(String message, final double first,
			final double second, final char operator) {
		// present the result
		message = message + first;
		switch (operator) {
		case Calculator.ADD: {
			message = message + " added to " + second;
			break;
		}
		case Calculator.SUB: {
			message = message + " subtracted by " + second;
			break;
		}
		case Calculator.MULT: {
			message = message + " multiplied by " + second;
			break;
		}
		case Calculator.DIV: {
			message = message + " divided by " + second;
			break;
		}
		case Calculator.POW: {
			message = message + " power to " + second;
			break;
		}
	

		}
		return message + " equals: ";
	}
}
