package model.factory;

import model.motoren.Motor;

public class MotorFactory
{

	/**
	 * Constructor for objects of class Motor
	 */
	public static final Motor createMotor()
	{
		final Motor motor = new Motor();
		// initialise instance variables
		switch ((int) (Math.random() * 5.0))
		{
		case 0:
			motor.setType("Diesel");
			break;
		case 1:
			motor.setType("Benzine");
			break;
		case 2:
			motor.setType("H20");
			break;
		case 3:
			motor.setType("Hybride");
			break;
		case 4:
			motor.setType("Electrisch");
			break;
		default:
			motor.setType("Zonder");
			break;
		}
		return motor;
	}

}
