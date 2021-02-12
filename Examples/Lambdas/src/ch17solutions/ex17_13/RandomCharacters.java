package ch17solutions.ex17_13;

// Exercise 17.13: RandomCharacters.java
// Counting word occurrences in a text file.
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RandomCharacters
{
	public static void main(final String[] args)
	{
		final List<Character> list = new ArrayList<>();
		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		final SecureRandom random = new SecureRandom();

		for (int i = 0; i < 30; ++i)
		{
			list.add(alphabet.charAt(random.nextInt(26)));
		}

		list.stream().sorted().forEach(c -> System.out.printf("%c ", c));
		System.out.println();

		final Comparator<Character> compare = Character::compareTo;

		list.stream().sorted(compare.reversed()).forEach(c -> System.out.printf("%c ", c));
		System.out.println();

		list.stream().distinct().sorted().forEach(c -> System.out.printf("%c ", c));
		System.out.println();
	}
} // end class StreamOfLines

/**************************************************************************
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
