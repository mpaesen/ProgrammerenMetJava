package model.vaartuigen;

import model.factory.MotorFactory;
import utilities.Category;

import java.math.BigDecimal;

public class MotorBoot extends Boot
{
	public MotorBoot(final Category cat, final BigDecimal waarde)
	{
		super(cat, waarde);
		setMotor(MotorFactory.createMotor());
	}

	@Override
	public String toString()
	{
		return super.toString() + "\n\t en heeft een \"" + getMotor() + "\" motor";
	}

}
