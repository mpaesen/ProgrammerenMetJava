package calculator.test;

import calculator.model.Calculator;
import calculator.view.GUIInput;
import calculator.view.GUIOutput;

public class Controller
{
	public static void main(String[] args) {
		GUIInput i=new GUIInput();
		Calculator calc=new Calculator();
		GUIOutput o=new GUIOutput();
		Controller c=new Controller(i,o,calc);
	}
	
	public Controller(GUIInput i, GUIOutput o, Calculator c) {
		while (true) {
			float op1=i.getOperand("Voer eerste operand in:");
			float op2=i.getOperand("Voer tweede operand in:");
			String operator=i.getOperator("Welke bewerking wil je uitvoern (+,-,* of /)?");
			c.setOperand1(op1);
			c.setOperand2(op2);
			if (operator.equals("+")) {
				o.showResult("Het resultaat van "+op1+" "+operator+" "+op2+" is: "+c.sum());
			} else if (operator.equals("-")) {
				o.showResult("Het resultaat van "+op1+" "+operator+" "+op2+" is: "+c.subtraction());
			} else if (operator.equals("*")) {
				o.showResult("Het resultaat van "+op1+" "+operator+" "+op2+" is: "+c.multiplication());
			} else if (operator.equals("/")) {
				o.showResult("Het resultaat van "+op1+" "+operator+" "+op2+" is: "+c.division());
			} else {
				o.showResult("De bewerking "+op1+" "+operator+" "+op2+" is niet geimplementeerd door de huidige calculator.");
			}
			if (!i.getNext("Nog bewerkingen?"))
				break;
		}
	}
}