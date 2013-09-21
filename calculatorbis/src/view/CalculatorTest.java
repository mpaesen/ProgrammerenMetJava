/**
 * 
 */

package view;

import javax.swing.JOptionPane;

import business.Calculator;

/**
 * @author mpaesen
 * @version 1.1
 *
 */
public class CalculatorTest
{

	/**
	 * @param args
	 */
	public static void main(final String[] args)
	{
		// TODO Auto-generated method stub
		double result;
		double first, second;
		char operator;
		String message = new String("The result of: \n");
		String input = JOptionPane.showInputDialog("Give first Value: ");
		//conversion of input into "first" value
		first = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Give second Value: ");
		//conversion of input into "second" value
		second = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Give the operation (+, -, *, /, ^): ");
		//substring of input into "operator"
		operator = input.charAt(0);
		final Calculator calculator = new Calculator();
		result = calculator.result(first, second, operator);
		//prepare message
		message = getResult(message, first, second, operator);
		message = String.format("%S %5.2f", message, result);
		//message += result;
		//show message
		JOptionPane.showMessageDialog(null, message);
	}

	public static String getResult(String message, final double first, final double second, final char operator)
	{
		//present the result
		message = message + first;
		if (operator == Calculator.ADD)
		{
			message = message + " added to " + second;
		}
		if (operator == Calculator.SUB)
		{
			message = message + " subtracted by " + second;
		}
		if (operator == Calculator.MULT)
		{
			message = message + " multiplied by " + second;
		}
		if (operator == Calculator.DIV)
		{
			message = message + " divided by " + second;
		}
		if (operator == Calculator.POW)
		{
			message = message + " power to " + second;
		}
		return message + " equals: ";
	}
}
