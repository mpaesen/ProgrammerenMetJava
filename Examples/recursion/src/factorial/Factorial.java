package factorial;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial
{
	public BigInteger factorial(final BigInteger fact)

	{
		if (fact.compareTo(BigInteger.ONE) > 0)
		{
			return fact.multiply(factorial(fact.subtract(BigInteger.ONE)));
		}
		return BigInteger.ONE;
	}

	public static void main(final String[] args)
	{
		final Scanner scanner = new Scanner(System.in);
		String input;
		int fact;
		do
		{
			System.out.println("\nGive a non negative integer or end with Q:");
			input = scanner.nextLine();
			if (!input.equalsIgnoreCase("Q"))
			{
				try
				{
					fact = Integer.parseInt(input);
					if (fact < 0)
					{
						throw new NumberFormatException();
					}

					final Factorial factor = new Factorial();
					System.out.printf("%d! = %d", fact, factor.factorial(new BigInteger(String.valueOf(fact))));
				}
				catch (final NumberFormatException e)
				{
					System.out.println("\n\tThis is not a non negative integer please try again!");

				}
			}
		}
		while (!input.equalsIgnoreCase("Q"));
		scanner.close();

	}
}
