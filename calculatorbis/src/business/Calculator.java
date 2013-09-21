/**
 * 
 */
package business;

/**
 * @author mpaesen
 * @version 1.1
 * @since 2013-09-21
 */
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
		return finalResult;
	}

}
