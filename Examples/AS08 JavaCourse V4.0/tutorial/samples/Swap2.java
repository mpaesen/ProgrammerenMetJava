package samples;


class Swap2

{

   public static void main( String[] args )

   {

	  Integer i = new Integer( 3 );

	  Integer j = new Integer( 4 );



	  Swap2.swap( i, j );

	  System.out.println( i + " " + j );

	  }  
   public static void swap(Integer x, Integer y)

   {

	  Integer temp = x;

	  x = y;

	  y = temp;

   }      
}