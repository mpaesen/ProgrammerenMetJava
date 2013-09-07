package model;

/**
 * @author bempn
 *
 */
public class PersonalAccount {
	private long acc; // The account number

	private Amount bal; // Amount in account at the moment

	// The default constructor
	public PersonalAccount() {// The default constructor
		acc = 0;
		bal = new Amount();
		bal.setValue(0.0);
	}

	// Selectors
	public long getAccountnr() {// The account number
		return acc;
	}

	public Amount getBalance() {// The balance
		return bal;
	}

	// Modifiers
	/**
	 * @param newaccount
	 */
	public void setAccountnr(long newaccount) {// Set the new account number
		acc = newaccount;
	}

	/**
	 * @param newbalance
	 */
	public void setBalance(Amount newbalance) {// Set the new balance
		bal = newbalance;
	}

	/**
	 * @param value
	 */
	public void deposit(double value) {// Deposit money
		// Check to see if the credit limit is not violated
		// value can also be negative so have to check
		Amount depo = new Amount(value);
		Amount newAmount = bal.add(depo);
		if (newAmount.getValue() < 0.00)
			return;
		bal = newAmount;
	}

	/**
	 * @param value
	 */
	public void withdraw(double value) {// Withdraw money from account
		// Check to see if the credit limit is not violated
		// value can also be negative so have to check
		Amount with = new Amount(value);
		Amount newAmount = bal.subtract(with);
		if (newAmount.getValue() < 0.00)
			return;

		bal = newAmount;

	}
	
	public String toString(){
		return "Account " + this.getAccountnr()+ " Value "+ this.getBalance();
	}
}
