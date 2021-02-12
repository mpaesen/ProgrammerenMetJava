package ch17solutions.ex17_12;

// Exercise 17.12 Solution: DuplicateWordRemoval.java
import java.util.Scanner;
import java.util.regex.Pattern;

public class DuplicateWordRemoval
{
	public static void main(final String[] args)
	{
		final Pattern pattern = Pattern.compile("\\s+");
		final Scanner input = new Scanner(System.in);
		System.out.println("Enter a sentence:");

		// create Path object based on user input
		final String userInput = input.nextLine();
		pattern.splitAsStream(userInput).map(String::toLowerCase).map(s -> s.replaceAll("(?!')\\p{P}", "")).distinct().sorted().forEach(System.out::println);
	}
}

/*************************************************************************
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
