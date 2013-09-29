/**
 * 
 */
package business;

/**
 * @author mpaesen
 * @version 1.1
 * @since 2013-09-21
 */
<<<<<<< HEAD
<<<<<<< HEAD
public class Calculator
{
	public static final char ADD = '+';
	public static final char SUB = '-';
	public static final char DIV = '/';
	public static final char MULT= '*';
	public static final char POW = '^';
	
	private double addition(final double first, final double second)
	{
		return first + second;
	}

	private double substraction(final double first, final double second)
	{
		return first - second;
	}

	private double multiplication(final double first, final double second)
	{
		return first * second;
	}

	private double division(final double first, final double second)
	{
		if (second != 0)
		{
			return first / second;
		}
		return 0;
	}

	public double result(final double first, final double second, final char operator)
	{
		double finalResult = 0;
		if (operator == ADD)
		{
			finalResult = addition(first, second);
		}
		if (operator == SUB)
		{
			finalResult = substraction(first, second);
		}
		if (operator == MULT)
		{
			finalResult = multiplication(first, second);
		}
		if (operator == DIV)
		{
			finalResult = division(first, second);
		}
		if (operator == POW)
		{
			finalResult = Math.pow(first, second);
		}	
=======
public class Calculator {
	public static final char ADD = '+';
	public static final char SUB = '-';
	public static final char DIV = '/';
	public static final char MULT = '*';
	public static final char POW = '^';
	public static final char ROOT = 'µ';

	private double addition(final double first, final double second) {
		return first + second;
	}

	private double substraction(final double first, final double second) {
		return first - second;
	}

	private double multiplication(final double first, final double second) {
		return first * second;
	}

	private double division(final double first, final double second) {
		if (second != 0) {
			return first / second;
		}
		return 0;
	}
	
	private double power(final double first, final double second) {
		return  Math.pow(first, second);
	}
	
	private double root(final double first, final double second) {
		if(second != 0){
			return  Math.pow(first, 1.0/second);
		}
		return 0;
	}


	public double result(final double first, final double second,
			final char operator) {
		double finalResult = 0;
		switch (operator) {
		case ADD: {
			finalResult = addition(first, second);
			break;
		}
		case SUB: {
			finalResult = substraction(first, second);
			break;
		}
		case MULT: {
			finalResult = multiplication(first, second);
			break;
		}
		case DIV: {
			finalResult = division(first, second);
			break;
		}
		case POW: {
			finalResult = power(first, second);
			break;
		}
		case ROOT: {
			finalResult = root(first, second);
			break;
		}
		default:
			break;
		}

>>>>>>> branch 'master' of https://github.com/mpaesen/ProgrammerenMetJava.git
=======
public class Calculator {
	public static final char ADD = '+';
	public static final char SUB = '-';
	public static final char DIV = '/';
	public static final char MULT = '*';
	public static final char POW = '^';
	public static final char ROOT = 'µ';

	private double addition(final double first, final double second) {
		return first + second;
	}

	private double substraction(final double first, final double second) {
		return first - second;
	}

	private double multiplication(final double first, final double second) {
		return first * second;
	}

	private double division(final double first, final double second) {
		if (second != 0) {
			return first / second;
		}
		return 0;
	}
	
	private double power(final double first, final double second) {
		return  Math.pow(first, second);
	}
	
	private double root(final double first, final double second) {
		if(second != 0){
			return  Math.pow(first, 1.0/second);
		}
		return 0;
	}


	public double result(final double first, final double second,
			final char operator) {
		double finalResult = 0;
		switch (operator) {
		case ADD: {
			finalResult = addition(first, second);
			break;
		}
		case SUB: {
			finalResult = substraction(first, second);
			break;
		}
		case MULT: {
			finalResult = multiplication(first, second);
			break;
		}
		case DIV: {
			finalResult = division(first, second);
			break;
		}
		case POW: {
			finalResult = power(first, second);
			break;
		}
		case ROOT: {
			finalResult = root(first, second);
			break;
		}
		default:
			break;
		}

>>>>>>> branch 'master' of https://github.com/mpaesen/ProgrammerenMetJava.git
		return finalResult;
	}

}
