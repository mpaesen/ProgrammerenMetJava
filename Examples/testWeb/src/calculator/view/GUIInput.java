package calculator.view;

import javax.swing.*;

public class GUIInput {
	
	public GUIInput() {
	}
	
	public float getOperand(String message) {
		String input="";
		float operand=0;
		try {
			input=JOptionPane.showInputDialog(message);
			operand=Float.parseFloat(input);
		} catch (Exception e) {
			getOperand(input+" is not a valid number\n"+message);
		}
		return operand;
	}
	
	public String getOperator(String message) {
		String operator=JOptionPane.showInputDialog(message);
		if (operator.equals("+")) {
			return operator;
		} else if (operator.equals("-")) {
			return operator;
		} else if (operator.equals("*")) {
			return operator;
		} else if (operator.equals("/")) {
			return operator;
		} else
			return getOperator(operator+" is not a valid operator, pls retry!\n"+message);
	}
	
	public boolean getNext(String message) {
		int option=JOptionPane.showConfirmDialog(null, message, "", JOptionPane.YES_NO_OPTION);
		return (option!=1);
	}
}