/**
 * 
 */
package business;

/**
 * @author mpaesen
 * @version 1.1
 *
 */
public class Calculator
{
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
		if (operator == '+')
		{
			finalResult = addition(first, second);
		}
		if (operator == '-')
		{
			finalResult = substraction(first, second);
		}
		if (operator == '*')
		{
			finalResult = multiplication(first, second);
		}
		if (operator == '/')
		{
			finalResult = division(first, second);
		}
		return finalResult;
	}

}
