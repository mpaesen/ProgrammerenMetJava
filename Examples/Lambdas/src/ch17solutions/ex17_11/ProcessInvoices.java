package ch17solutions.ex17_11;

// Exercise 17.11: ProcessInvoices.java
// Processing Invoices with lambdas and streams.
import java.util.Arrays;
import java.util.Comparator;

public class ProcessInvoices
{
	public static void main(final String[] args)
	{
		final Invoice[] invoices = { new Invoice(83, "Electric sander", 7, 57.98), new Invoice(24, "Power saw", 18, 99.99), new Invoice(7, "Sledge hammer", 11, 21.50), new Invoice(77, "Hammer", 76, 11.99), new Invoice(39, "Lawn mower", 3, 79.50), new Invoice(68, "Screwdriver", 106, 6.99),
				new Invoice(56, "Jig saw", 21, 11.00), new Invoice(3, "Wrench", 34, 7.50) };

		System.out.println("Invoices sorted by part description:");
		Arrays.stream(invoices).sorted(Comparator.comparing(Invoice::getPartDescription)).forEach(System.out::println);

		System.out.printf("%nnInvoices sorted by price:%n");
		Arrays.stream(invoices).sorted(Comparator.comparing(Invoice::getPrice)).forEach(System.out::println);

		System.out.printf("%nInvoices mapped to description and quantity:%n");
		Arrays.stream(invoices).sorted(Comparator.comparing(Invoice::getQuantity)).map(invoice -> String.format("Description: %-15s  Quantity: %d", invoice.getPartDescription(), invoice.getQuantity())).forEach(System.out::println);

		System.out.printf("%nInvoices mapped to description and invoice amount:%n");
		Arrays.stream(invoices).sorted(Comparator.comparingDouble(invoice -> invoice.getQuantity() * invoice.getPrice())).map(invoice -> String.format("Description: %-15s  Invoice amount: %7.2f", invoice.getPartDescription(), invoice.getQuantity() * invoice.getPrice())).forEach(System.out::println);

		System.out.printf("%nInvoices mapped to description and invoice amount for invoices in the range 200-500:%n");
		Arrays.stream(invoices).filter(invoice -> invoice.getQuantity() * invoice.getPrice() >= 200 && invoice.getQuantity() * invoice.getPrice() <= 500).sorted(Comparator.comparingDouble(invoice -> invoice.getQuantity() * invoice.getPrice()))
				.map(invoice -> String.format("Description: %-15s  Invoice amount: %7.2f", invoice.getPartDescription(), invoice.getQuantity() * invoice.getPrice())).forEach(System.out::println);
	}
}

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
