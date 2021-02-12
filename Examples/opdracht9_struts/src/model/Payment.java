package model;

import java.io.Serializable;

/**
 * @author Erwin Aernouts
 */

public class Payment implements Serializable
{
	private static final long serialVersionUID = 1L;
	private double amount;
	
	public Payment(double payed)
	{
		this.setAmount(payed);
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
}
