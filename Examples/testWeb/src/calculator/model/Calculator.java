package calculator.model ;


public class Calculator
{
	private float operand1, operand2, operand3;
	
	
	public Calculator() {
	}
	
	public Calculator(float operand1) {
	}
	
	public Calculator(float operand1, float operand2) {
	}
	
	public Calculator(float operand1, float operand2, float operand3) {
	}
	
	public void setOperand1(float op) {
		operand1=op;
	}
	
	public void setOperand2(float op) {
		operand2=op;
	}	
	
	public float sum() {
		return operand1+operand2;
	}
	
	public float subtraction() {
		return operand1-operand2;
	}
	
	public float multiplication() {
		return operand1*operand2;
	}
	
	public float division() {
		return operand1/operand2;
	}
}