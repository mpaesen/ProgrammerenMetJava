package fibonacci;

import java.math.BigInteger;

public class Fibonnacci
{

	public BigInteger solveFibonnacci(final BigInteger number)
	{
		switch (number.intValue())
		{
		case 0:
			return BigInteger.ZERO;
		case 1:
			return BigInteger.ONE;
		default:
			return solveFibonnacci(number.subtract(BigInteger.ONE)).add(solveFibonnacci(number.subtract(BigInteger.valueOf(2))));
		}
	}

	public static void main(final String[] args)
	{

		final Fibonnacci fib = new Fibonnacci();
		for (int i = 0; i < 40; i++)
		{
			System.out.printf("\nfib %d=%d", i, fib.solveFibonnacci(BigInteger.valueOf(i)));
		}
	}

}
