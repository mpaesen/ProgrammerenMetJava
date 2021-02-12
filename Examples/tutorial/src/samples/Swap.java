package samples;


class Swap

{

	public static void main( String[] args )

	{

	int i = 3, j = 4;

	Swap.swap( i, j );

	System.out.println( i + " " + j );

	}
   public static void swap( int x, int y )

	{

	int temp = x;

	x = y;

	y = temp;

	}
}