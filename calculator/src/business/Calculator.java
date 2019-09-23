/**
 * 
 */
package business;

/**
 * Implements a basic calculator
 * @author mpaesen
 * @version 1.1
 * @since 2013-09-21
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

    private double division(final double first, final double second) throws ArithmeticException
	{
		if (second != 0)
		{
			return first / second;
		}
        throw new ArithmeticException("Warning: Divide by zero is not allowed!");
        //return 0;
    }

    public double result(final double first, final double second, final Operator operator) {
		double finalResult = 0;
        try {
            switch (operator) {
                case ADD:
                    finalResult = addition(first, second);
                    break;

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
                    finalResult = Math.pow(first, second);
                    break;
                }
            }
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
		return finalResult;
	}

}
