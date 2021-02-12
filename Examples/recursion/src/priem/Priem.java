package priem;

import java.util.ArrayList;

public class Priem
{

	/* De vraag is: waar ligt het omslagpunt, ofwel tot waar moet ik testen om er zeker van te zijn dat een getal priem is? Het antwoord luidt: tot de wortel van het getal. 
	 1 Max = Invoer
	 2 Voor Getal = 2 Tot Max
	 3 Voor Deler = 2 Tot Wortel(Getal)
	 4 Als Getal Modulo Deler = 0 GoTo 8
	 5 Volgende Deler
	 6 Print Getal " is een priemgetal"
	 7 GoTo 10
	 8 Print Getal " is geen priemgetal"
	 9 Volgende Getal
	 10 Print "Klaar"
	*/
	public static boolean isPriem(final int max)
	{
		if (max == 2)
		{
			return true;
		}

		if ((max < 2) || (0 == (max % 2)))
		{
			return false;
		}

		int deler = 0;
		final int wortel = (int) Math.sqrt(max);
		//System.out.println("sqrt" + wortel);
		if (wortel > 2)
		{
			for (deler = 2; deler <= wortel; deler++)
			{
				if (0 == max % deler)
				{
					return false;
				}
			}
		}
		return true;
	}

	public static Object[] priem(final int getal)
	{
		final ArrayList getallen = new ArrayList();

		for (int i = 0; i < getal; i++)
		{
			if (isPriem(i))
			{
				getallen.add(new Integer(i));
			}
		}
		return getallen.toArray();
	}

	public static void main(final String[] args)
	{
		System.out.println("input vb: Priem getal");
		final int i = Integer.parseInt(args[0]);
		final Object[] priemGetallen = priem(i);

		System.out.println("De priem getallen voor " + i + " zijn");
		for (final Object o : priemGetallen)
		{
			System.out.print(((Integer) o).intValue() + " ");
		}
		//System.out.println("het getal " + i + " is " + (isPriem(i)?"een ":"geen ")+ "priem getal");	
	}
}