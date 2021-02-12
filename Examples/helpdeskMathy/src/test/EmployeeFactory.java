package test;

import database.dao.DAOEmployee;

import java.util.Random;

public class EmployeeFactory {
	private static final String NAMES[] = { "Niko", "Koen", "Stijn", "Kurt",
			"Alain", "Gert" };

	private static final int ROLES[] = { 10, 20, 30, 40, 50 };
	private static  int number = 1;

	public static DAOEmployee getEmployee(Random rand){
		DAOEmployee employee= new DAOEmployee();
		employee.setName(NAMES[rand.nextInt(NAMES.length)]);
		employee.setRole(ROLES[rand.nextInt(ROLES.length)]);
		employee.setNumber(number++);
			return employee;
	}
}
