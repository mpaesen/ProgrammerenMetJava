package model.vaartuigen;

import java.math.BigDecimal;

import model.factory.Motoren;
import model.motoren.Motor;

import utilities.Category;


public class MotorBoot extends Boot {
	public MotorBoot(Category cat, BigDecimal waarde){
		super(cat, waarde);
		motor = Motoren.createRandomMotor();
	}
	/**
	 * @return Returns the motor.
	 */
	public Motor getMotor() {
		return motor;
	}

	/**
	 * @param motor The motor to set.
	 */
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	public String toString(){
		return super.toString()+ " en heeft een "+ getMotor();
	}
	
}
