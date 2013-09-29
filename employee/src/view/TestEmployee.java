package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import business.Employee;

public class TestEmployee {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final ArrayList<Employee> list = new ArrayList<Employee>();
		mainIteration(list);
		showOutput(list);
		showOneEmployee(list);
	}

	public static void showOneEmployee(final ArrayList<Employee> list) {
		String input;
		int i;
		String range = "1 - ";
		range += list.size();
		do {
			do {
				input = getInput("Give a employee Number ( "+range+"): ");
			} while (input.isEmpty());

			i = Integer.parseInt(input);
			i-=1;
		} while ((i < 0) || (i > list.size()-1));
		System.out.println(list.get(i));
	}

	/**
	 * @param list
	 */
	private static void showOutput(final ArrayList<Employee> list) {
		for (final Employee employees : list) {
			System.out.println(employees);
		}
		System.out.println("We have created: " + Employee.getSequence()
				+ " employees.");

	}

	/**
	 * @param list
	 */
	private static void mainIteration(final ArrayList<Employee> list) {
		String input;
		String first;
		String name;
		Employee employee;
		do {
			input = getInput("Give firstname (Q to quit, anything else to continue");
			if (!input.equalsIgnoreCase("Q")) {
				first = input;
				input = getInput("Give the name :");
				name = input;
				employee = new Employee(name, first);
				list.add(employee);
			}
		} while (!input.equalsIgnoreCase("Q"));
	}

	public static String getInput(final String message) {
		return JOptionPane.showInputDialog(message);
	}
}
