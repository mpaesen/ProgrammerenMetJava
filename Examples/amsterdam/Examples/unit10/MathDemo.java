package unit10;

public class MathDemo
{

	public static void main(final String[] args)
	{
		final double values[] = { 11.5, 12.5, -12.5, -13.5 };
		for (int i = 0; i < values.length; i++)
		{
			final double current = values[i];
			System.out.println("value: " + current);
			System.out.println("ceil:  " + Math.ceil(current));
			System.out.println("floor: " + Math.floor(current));
			System.out.println("round: " + Math.round(current));
			System.out.println();
		}
	}
}