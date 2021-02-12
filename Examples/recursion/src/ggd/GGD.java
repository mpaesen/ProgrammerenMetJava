package ggd;

public class GGD
{

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

	public static void main(final String[] args)
	{
		System.out.println("input vb: GGD getal1 getal2");
		final int factor1 = Integer.parseInt(args[0]);
		final int factor2 = Integer.parseInt(args[1]);
		System.out.println("ggd = " + ggd(factor1, factor2));
	}
}