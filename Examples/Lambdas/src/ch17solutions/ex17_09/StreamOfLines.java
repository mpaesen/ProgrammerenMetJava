package ch17solutions.ex17_09;

// Fig. 17.17: StreamOfLines.java
// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamOfLines
{
	public static void main(final String[] args) throws IOException
	{
		// count occurrences of each letter in a Stream<String> sorted by letter
		final Map<String, Long> characterCounts = Files.lines(Paths.get("Chapter2Paragraph.txt")).map(line -> line.replaceAll("\\W", "")).map(String::toUpperCase).flatMapToInt(String::chars).mapToObj(c -> (char) c).collect(Collectors.groupingBy(String::valueOf, TreeMap::new, Collectors.counting()));

		// display the letters grouped by starting letter
		characterCounts.entrySet().stream().filter(entry -> !entry.getKey().isEmpty()).forEach(entry -> {
			System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
		});
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
