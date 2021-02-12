package kgv;

public class KGV
{

	/* algoritme van Euclides */
	public static int ggd(final int a, final int b)
	{
		if (b == 0)
		{
			return a;
		}
		else
		{
			return ggd(b, a % b);
		}
	}

	/* smallest/lowest common multiple */
	/* ggd(a,b) x kgv(a,b) = a x b. */

	public static int kgv(final int a, final int b)
	{
		return a * b / ggd(a, b);
	}

	public static void main(final String[] args)
	{
		System.out.println("input vb: KGV getal1 getal2");
		final int factor1 = Integer.parseInt(args[0]);
		final int factor2 = Integer.parseInt(args[1]);
		System.out.println("kgv = " + kgv(factor1, factor2));
	}
}