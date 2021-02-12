/**
 * 
 */
package business;

/**
 * @author mpaesen
 * 
 */

public class Amount {
	private double amount;
	private final int number;
	private final static double INVERS = -1.0;
	private final static double ZERO = 0.0;
	private static int sequence;

	public enum Transaction {
		DEPOSIT, CREDIT, MULTIPLY
	};

	public Amount(final double amount) {
		super();
		number = ++sequence;
		this.amount = amount;
	}

	public Amount(final Amount amount) {
		this(amount.getAmount());
	}

	public Amount() {
		this(ZERO);
	}
	
	public Amount clone(){
		return new Amount(this.getAmount());
	}

	public int getNumber() {
		return number;
	}

	public static int getSequence() {
		return sequence;
	}
	public void inverseSign() {
		amount *= INVERS;
	}

	public void reset() {
		setAmount(ZERO);
	}

	public void makePositive() {
		if (isNegative()) {
			inverseSign();
		}
	}

	public void makeNegative() {
		if (!isNegative()) {
			inverseSign();
		}
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(final double amount) {
		this.amount = amount;
	}

	private void add(final Amount amount) {
		this.amount += amount.getAmount();
	}

	private void subtract(final Amount amount) {
		this.amount -= amount.getAmount();
	}

	private void multiply(final Amount amount) {
		this.amount *= amount.getAmount();
	}

	public boolean isNegative() {
		return this.amount < ZERO;
	}

	/**
	 * Modifies an amount via a transaction and an amount
	 * 
	 * @param transaction
	 * @param amount
	 */
	public void modify(final Transaction transaction, final Amount amount) {
		switch (transaction) {
		case CREDIT: {
			subtract(amount);
			break;
		}
		case DEPOSIT: {
			add(amount);
			break;
		}
		case MULTIPLY:
			multiply(amount);
			break;
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return String.format(
				"\n\t\tAmount [getNumber()=%d, getAmount()=%,10.2f]",
				getNumber(), getAmount());
	}

	public boolean equals(final Amount amount) {
		return this.getAmount() == amount.getAmount();
	}


}
